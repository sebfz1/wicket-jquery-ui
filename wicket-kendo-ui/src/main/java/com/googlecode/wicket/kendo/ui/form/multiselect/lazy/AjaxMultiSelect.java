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
package com.googlecode.wicket.kendo.ui.form.multiselect.lazy;

import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.JQueryEvent;
import com.googlecode.wicket.jquery.core.ajax.IJQueryAjaxAware;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxBehavior;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxPostBehavior;
import com.googlecode.wicket.jquery.core.event.ISelectionChangedListener;
import com.googlecode.wicket.jquery.core.renderer.IChoiceRenderer;
import com.googlecode.wicket.kendo.ui.ajax.OnChangeAjaxBehavior;
import com.googlecode.wicket.kendo.ui.ajax.OnChangeAjaxBehavior.ChangeEvent;

/**
 * Provides a Kendo UI MultiSelect widget.<br/>
 * This ajax version will post the {@link Component}, using a {@link JQueryAjaxPostBehavior}, when the 'change' javascript method is called. TODO javadoc
 * 
 * @author Sebastien Briquet - sebfz1
 */
public abstract class AjaxMultiSelect<T> extends MultiSelect<T> implements IJQueryAjaxAware, ISelectionChangedListener
{
	private static final long serialVersionUID = 1L;

	/** AjaxBehavior, exceptionally hold in component */
	private JQueryAjaxBehavior onChangeAjaxBehavior;

	public AjaxMultiSelect(String id)
	{
		super(id);
	}

	public AjaxMultiSelect(String id, IModel<? extends Collection<T>> model)
	{
		super(id, model);
	}

	public AjaxMultiSelect(String id, IChoiceRenderer<? super T> renderer)
	{
		super(id, renderer);
	}

	public AjaxMultiSelect(String id, IModel<? extends Collection<T>> model, IChoiceRenderer<? super T> renderer)
	{
		super(id, model, renderer);
	}

	// Events //

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.onChangeAjaxBehavior = new OnChangeAjaxBehavior(this);
		this.add(this.onChangeAjaxBehavior);
	}

	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		super.onConfigure(behavior);

		behavior.setOption("change", this.onChangeAjaxBehavior.getCallbackFunction());
	}

	@Override
	public void onAjax(AjaxRequestTarget target, JQueryEvent event)
	{
		if (event instanceof ChangeEvent)
		{
			this.onSelectionChanged();
			this.onSelectionChanged(target);
		}
	}

	/**
	 * Triggers when the selection has changed
	 */
	public final void onSelectionChanged()
	{
		this.convertInput();
		this.updateModel();
	}

	@Override
	public void onSelectionChanged(AjaxRequestTarget target)
	{
		// noop
	}
}
