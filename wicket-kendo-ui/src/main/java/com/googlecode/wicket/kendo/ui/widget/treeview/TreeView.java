/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.kendo.ui.widget.treeview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.lang.Args;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.JQueryContainer;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.template.IJQueryTemplate;
import com.googlecode.wicket.kendo.ui.KendoTemplateBehavior;
import com.googlecode.wicket.kendo.ui.KendoUIBehavior;
import com.googlecode.wicket.kendo.ui.scheduler.SchedulerDataSource;
import com.googlecode.wicket.kendo.ui.scheduler.SchedulerEventFactory;
import com.googlecode.wicket.kendo.ui.scheduler.resource.ResourceListModel;

/**
 * Provides the Kendo UI Scheduler
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class TreeView<T> extends JQueryContainer implements ITreeViewListener
{
	private static final long serialVersionUID = 1L;

	private final Options options;
	private TreeViewModelBehavior<T> modelBehavior; // load events

	// templates //
	private IJQueryTemplate template;
	private KendoTemplateBehavior templateBehavior = null;

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public TreeView(String id)
	{
		this(id, null, new Options());
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param options the {@link Options}
	 */
	public TreeView(String id, Options options)
	{
		this(id, null, options);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link TreeViewModel}
	 * @param resourceListModel the {@link ResourceListModel}
	 */
	public TreeView(String id, TreeViewModel<T> model)
	{
		this(id, model, new Options());
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link TreeViewModel}
	 * @param resourceListModel the {@link ResourceListModel}
	 * @param options the {@link Options}
	 */
	public TreeView(String id, TreeViewModel<T> model, Options options)
	{
		super(id, model);

		this.options = Args.notNull(options, "options");
	}

	// Methods //

	/**
	 * Gets the Kendo UI widget
	 *
	 * @return the jQuery object
	 */
	public String widget()
	{
		return KendoUIBehavior.widget(this, TreeViewBehavior.METHOD);
	}

	/**
	 * Refreshes the events currently available in the selected view.
	 *
	 * @param target the {@link AjaxRequestTarget}
	 */
	public void refresh(AjaxRequestTarget target)
	{
		target.appendJavaScript(String.format("var widget = %s; widget.dataSource.read(); widget.refresh();", this.widget()));

		this.onRefresh(target);
	}

	// Properties //

	/**
	 * Gets the sheduler's model
	 *
	 * @return the {@link TreeViewModel}
	 */
	@SuppressWarnings("unchecked")
	public TreeViewModel<T> getModel()
	{
		return (TreeViewModel<T>) this.getDefaultModel();
	}

	// Events //

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.modelBehavior = this.newTreeViewModelBehavior(this.getModel(), this.newTreeViewNodeFactory());
		this.add(this.modelBehavior);

		// templates //

		this.template = this.newTemplate();

		if (this.template != null)
		{
			this.templateBehavior = new KendoTemplateBehavior(this.template);
			this.add(this.templateBehavior);
		}
	}

	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		super.onConfigure(behavior);

		behavior.setOption("dataTextField", Options.asString(this.modelBehavior.getFactory().getTextField())); // 'text'

		// set templates (if any) //
		if (this.templateBehavior != null)
		{
			behavior.setOption("editable", String.format("{ template: jQuery('#%s').html() }", this.templateBehavior.getToken()));
		}
	}

	/**
	 * Configure the {@link SchedulerDataSource} with additional options
	 * 
	 * @param dataSource the {@link SchedulerDataSource}
	 */
	protected void onConfigure(TreeViewDataSource dataSource)
	{
		dataSource.set("schema", String.format("{ model: { id: '%s', hasChildren: true } }", this.modelBehavior.getFactory().getIdField()));
	}

	/**
	 * Triggered when {@link #refresh(AjaxRequestTarget)} has been called
	 * 
	 * @param target the {@link AjaxRequestTarget}
	 */
	protected void onRefresh(AjaxRequestTarget target)
	{
		// noop
	}

	// IJQueryWidget //

	/**
	 * see {@link JQueryContainer#newWidgetBehavior(String)}
	 */
	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new TreeViewBehavior(selector, this.options, this) {

			private static final long serialVersionUID = 1L;

			// Properties //

			@Override
			protected CharSequence getDataSourceUrl()
			{
				return TreeView.this.modelBehavior.getCallbackUrl();
			}

			// Events //

			@Override
			protected void onConfigure(TreeViewDataSource dataSource)
			{
				TreeView.this.onConfigure(dataSource);
			}
		};
	}

	// Factory methods //

	/**
	 * Gets a new {@link IJQueryTemplate} to customize the built-in edit window
	 * 
	 * @return null by default
	 */
	protected IJQueryTemplate newTemplate()
	{
		return null;
	}

	/**
	 * Gets a new {@link SchedulerEventFactory}
	 * 
	 * @return a new {@code SchedulerEventFactory}
	 */
	protected TreeViewNodeFactory<T> newTreeViewNodeFactory()
	{
		return new TreeViewNodeFactory<T>();
	}

	/**
	 * Gets a new {@link TreeViewModelBehavior}
	 *
	 * @param model the {@link TreeViewModel}
	 * @return the {@link TreeViewModelBehavior}
	 */
	protected TreeViewModelBehavior<T> newTreeViewModelBehavior(final TreeViewModel<T> model, final TreeViewNodeFactory<T> factory)
	{
		return new TreeViewModelBehavior<T>(model, factory);
	}
}
