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
package com.googlecode.wicket.kendo.ui.widget.accordion;

import org.apache.wicket.Component;

import com.googlecode.wicket.jquery.core.IJQueryWidget.JQueryWidget;
import com.googlecode.wicket.kendo.ui.KendoUIBehavior;

/**
 * Provides the ability to expands panes
 *
 * @author Sebastien Briquet - sebfz1
 * @since 6.19.0
 * @since 7.0.0
 */
public class ExpandBehavior extends KendoUIBehavior
{
	private static final long serialVersionUID = 1L;

	// TODO: move to AccordionBehavior (when will exists)
	static final String METHOD = "kendoPanelBar";
	
	/** children selector TODO: to be supplied through ctors */
	private static final String CHILDREN_ALL = "li";

	/**
	 * Constructor
	 */
	public ExpandBehavior()
	{
		super(null, METHOD);
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 */
	public ExpandBehavior(String selector)
	{
		super(selector, METHOD);
	}

	/**
	 * Constructor
	 *
	 * @param component the {@link Component}
	 */
	public ExpandBehavior(Component component)
	{
		super(JQueryWidget.getSelector(component), METHOD);
	}

	// Properties //

	@Override
	public boolean isTemporary(Component component)
	{
		return true;
	}

	// Methods //

	@Override
	public void bind(Component component)
	{
		super.bind(component);

		if (this.selector == null)
		{
			this.selector = JQueryWidget.getSelector(component);
		}
	}

	@Override
	public String $()
	{
		return String.format("%s.expand(jQuery('%s'), false);", this.widget(), CHILDREN_ALL);
	}
}
