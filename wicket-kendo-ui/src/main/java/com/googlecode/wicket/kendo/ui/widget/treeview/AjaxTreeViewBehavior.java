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

import org.apache.wicket.Component;
import org.apache.wicket.util.lang.Args;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.kendo.ui.KendoUIBehavior;

/**
 * Provides the Kendo UI TreeView behavior
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public abstract class AjaxTreeViewBehavior extends KendoUIBehavior
{
	private static final long serialVersionUID = 1L;

	public static final String METHOD = "kendoTreeView";

	@SuppressWarnings("unused")
	private final ITreeViewListener listener;
	private final TreeViewDataSource dataSource;

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param factory the {@link TreeViewNodeFactory}
	 * @param listener the {@link ITreeViewListener}
	 */
	public AjaxTreeViewBehavior(final String selector, ITreeViewListener listener)
	{
		this(selector, new Options(), listener);
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param options the {@link Options}
	 * @param factory the {@link TreeViewNodeFactory}
	 * @param listener the {@link ITreeViewListener}
	 */
	public AjaxTreeViewBehavior(final String selector, Options options, ITreeViewListener listener)
	{
		super(selector, METHOD, options);

		this.listener = Args.notNull(listener, "listener");
		this.dataSource = new TreeViewDataSource("TreeViewDataSource");
		this.add(this.dataSource);
	}

	// Properties //

	/**
	 * Gets the data-source behavior's url
	 *
	 * @return the data-source behavior's url
	 */
	protected abstract CharSequence getDataSourceUrl();

	// Events //

	@Override
	public void onConfigure(Component component)
	{
		super.onConfigure(component);

		// options //
		this.setOption("autoBind", true);
		this.setOption("loadOnDemand", true); // ajax

		// data-source //
		this.onConfigure(this.dataSource);
		this.setOption("dataSource", this.dataSource.getName());

		this.dataSource.setTransportRead(Options.asString(this.getDataSourceUrl()));
	}

	/**
	 * Configure the {@link TreeViewDataSource} with additional options
	 * 
	 * @param dataSource the {@link TreeViewDataSource}
	 */
	protected void onConfigure(TreeViewDataSource dataSource)
	{
		// noop
	}
}
