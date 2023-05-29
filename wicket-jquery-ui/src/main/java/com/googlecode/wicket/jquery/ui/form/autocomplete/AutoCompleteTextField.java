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
package com.googlecode.wicket.jquery.ui.form.autocomplete;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import com.googlecode.wicket.jquery.core.Options;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.convert.IConverter;

import com.googlecode.wicket.jquery.core.IJQueryWidget;
import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.renderer.ITextRenderer;
import com.googlecode.wicket.jquery.core.renderer.TextRenderer;
import com.googlecode.wicket.jquery.core.template.IJQueryTemplate;
import com.googlecode.wicket.jquery.core.utils.RequestCycleUtils;
import com.googlecode.wicket.jquery.ui.template.JQueryTemplateBehavior;

/**
 * Provides a jQuery auto-complete widget
 *
 * @param <T> the type of the model object
 * @author Sebastien Briquet - sebfz1
 */
public abstract class AutoCompleteTextField<T extends Serializable> extends AbstractAutoCompleteTextField<T, Integer>  // NOSONAR
{
	private static final long serialVersionUID = 1L;


	private abstract class IndexIAutoCompleteHandler implements IAutoCompleteHandler<T, Integer> {

		@Override
		public Integer getId(T choice, int index)
		{
			return index;
		}

		@Override
		public Integer indexToId(String index) {
			try {
				return Integer.parseInt(index);
			} catch (NumberFormatException e) {
				return -1;
			}

		}

		@Override
		public T selectChoice(Integer index) {
			if (-1 < index && index < choices.size())
			{
				return choices.get(index);
			}
			return null;
		}
	}

	public AutoCompleteTextField(String id)
	{
		super(id);
	}

	public AutoCompleteTextField(String id, Class<T> type)
	{
		super(id, type);
	}

	public AutoCompleteTextField(String id, ITextRenderer<? super T> renderer)
	{
		super(id, renderer);
	}

	public AutoCompleteTextField(String id, ITextRenderer<? super T> renderer, Class<T> type)
	{
		super(id, renderer, type);
	}

	public AutoCompleteTextField(String id, IModel<T> model)
	{
		super(id, model);
	}

	public AutoCompleteTextField(String id, IModel<T> model, Class<T> type)
	{
		super(id, model, type);
	}

	public AutoCompleteTextField(String id, IModel<T> model, ITextRenderer<? super T> renderer)
	{
		super(id, model, renderer);
	}

	public AutoCompleteTextField(String id, IModel<T> model, TextRenderer<T> renderer, Class<T> tClass)
	{
		super(id, model, renderer, tClass);
	}

	/**
	 * Cache of current choices, needed to retrieve the user selected object
	 */
	private List<T> choices;


	@Override
	protected IAutoCompleteHandler<T, Integer> newHandler() {
		return new IndexIAutoCompleteHandler() {
			@Override
			public List<T> getChoices(String term) {
				AutoCompleteTextField.this.choices = AutoCompleteTextField.this.getChoices(term);
				return AutoCompleteTextField.this.choices;
			}
		};
	}

	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		// noop
	}

	@Override
	public void onBeforeRender(JQueryBehavior behavior)
	{
	}

	/**
	 * Gets choices matching the provided input
	 *
	 * @param input String that represent the query
	 * @return the list of choices
	 */
	protected abstract List<T> getChoices(String input);

	@Override
	protected void onComponentTag(final ComponentTag tag)
	{
		super.onComponentTag(tag);

		tag.put("autocomplete", "off"); // disable browser's autocomplete
	}
}
