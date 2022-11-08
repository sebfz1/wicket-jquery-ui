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

import com.googlecode.wicket.jquery.core.IJQueryWidget;
import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.renderer.ITextRenderer;
import com.googlecode.wicket.jquery.core.renderer.TextRenderer;
import com.googlecode.wicket.jquery.core.template.IJQueryTemplate;
import com.googlecode.wicket.jquery.core.utils.RequestCycleUtils;
import com.googlecode.wicket.jquery.ui.template.JQueryTemplateBehavior;
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

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * Provides a jQuery auto-complete widget
 *
 * @param <T> the type of the model object
 * @author Sebastien Briquet - sebfz1
 */
public abstract class AbstractAutoCompleteTextField<T extends Serializable, I> extends TextField<T> implements IJQueryWidget, IAutoCompleteListener<I> // NOSONAR
{
	private static final long serialVersionUID = 1L;

	private static final JavaScriptResourceReference JS = new JavaScriptResourceReference(AbstractAutoCompleteTextField.class, "AutoCompleteTextField.js");

	/**
	 * Behavior that will be called when the user enters an input
	 */
	private AutoCompleteChoiceModelBehavior<T, I> choiceModelBehavior;

	private final ITextRenderer<? super T> renderer;
	private final IConverter<T> converter;

	private final IAutoCompleteHandler<T, I> handler;

	private final IJQueryTemplate template;
	private JQueryTemplateBehavior templateBehavior = null;


	/**
	 * Setting this flag to true adds some extra protection at client side
	 * preventing users to be able to select stale elements.
	 */
	private boolean preventSelectWhileQueryIsRunning = false;

	private AutoCompleteBehavior<I> autoCompleteBehavior;

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public AbstractAutoCompleteTextField(String id)
	{
		this(id, new TextRenderer<>());
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param type the type of the bean. This parameter should be supplied for the internal converter ({@link #getConverter(Class)}) to be used.
	 */
	public AbstractAutoCompleteTextField(String id, Class<T> type)
	{
		this(id, new TextRenderer<>(), type);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param renderer the {@link ITextRenderer}
	 */
	public AbstractAutoCompleteTextField(String id, ITextRenderer<? super T> renderer)
	{
		this(id, renderer, null);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param renderer the {@link ITextRenderer}
	 * @param type the type of the bean. This parameter should be supplied for the internal converter ({@link #getConverter(Class)}) to be used.
	 */
	public AbstractAutoCompleteTextField(String id, ITextRenderer<? super T> renderer, Class<T> type)
	{
		super(id, type);

		this.renderer = renderer;
		this.template = this.newTemplate();
		this.converter = this.newConverter();
		this.handler = this.newHandler();
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 */
	public AbstractAutoCompleteTextField(String id, IModel<T> model)
	{
		this(id, model, new TextRenderer<>(), null);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param type the type of the bean. This parameter should be supplied for the internal converter ({@link #getConverter(Class)}) to be used.
	 */
	public AbstractAutoCompleteTextField(String id, IModel<T> model, Class<T> type)
	{
		this(id, model, new TextRenderer<>(), type);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param renderer the {@link ITextRenderer}
	 */
	public AbstractAutoCompleteTextField(String id, IModel<T> model, ITextRenderer<? super T> renderer)
	{
		this(id, model, renderer, null);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param renderer the {@link ITextRenderer}
	 * @param type the type of the bean. This parameter should be supplied for the internal converter ({@link #getConverter(Class)}) to be used.
	 */
	public AbstractAutoCompleteTextField(String id, IModel<T> model, ITextRenderer<? super T> renderer, Class<T> type)
	{
		super(id, model, type);

		this.renderer = renderer;
		this.template = this.newTemplate();
		this.converter = this.newConverter();
		this.handler = this.newHandler();
	}

	// Methods //

	@Override
	protected final String getModelValue()
	{
		return this.renderer.getText(this.getModelObject()); // renderer cannot be null.
	}

	@Override
	@SuppressWarnings("unchecked")
	public <C> IConverter<C> getConverter(Class<C> type)
	{
		// TODO: manage String (property)model object in a better way
		if (!String.class.isAssignableFrom(this.getType()))
		{
			if (type != null && type.isAssignableFrom(this.getType()))
			{
				return (IConverter<C>) this.converter;
			}
		}

		return super.getConverter(type);
	}

	/**
	 * Gets the template script token/id
	 * 
	 * @return the template script token/id
	 */
	public String getTemplateToken()
	{
		if (this.templateBehavior != null)
		{
			return this.templateBehavior.getToken();
		}

		return null;
	}

	// Properties //

	/**
	 * Gets the {@link ITextRenderer}
	 *
	 * @return the {@link ITextRenderer}
	 */
	public ITextRenderer<? super T> getRenderer()
	{
		return this.renderer;
	}

	// Events //

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.choiceModelBehavior = this.newChoiceModelBehavior();
		this.add(this.choiceModelBehavior);

		this.add(JQueryWidget.newWidgetBehavior(this)); // cannot be in ctor as the markupId may be set manually afterward

		if (this.template != null)
		{
			this.templateBehavior = new JQueryTemplateBehavior(this.template);
			this.add(this.templateBehavior);
		}
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

	@Override
	protected void onComponentTag(final ComponentTag tag)
	{
		super.onComponentTag(tag);

		tag.put("autocomplete", "off"); // disable browser's autocomplete
	}

	@Override
	public final void onSelect(AjaxRequestTarget target, I index)
	{
		T selected = handler.selectChoice(index);
		if (selected != null) {
			this.setModelObject(selected);
			this.onSelected(target);
		} else {
			this.onSelectionFailed(target, index);
		}
	}

	/**
	 * Triggered when the user selects an item from results that matched its input
	 *
	 * @param target the {@link AjaxRequestTarget}
	 */
	protected void onSelected(AjaxRequestTarget target)
	{
	}

	/**
	 * Called when teh selection failed.
	 *
	 * @param target the {@link AjaxRequestTarget}
	 * @param index the selected index
	 */
	protected void onSelectionFailed(AjaxRequestTarget target, I index)
	{
	}

	// IJQueryWidget //

	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return autoCompleteBehavior = new AutoCompleteBehavior<>(selector, this) { // NOSONAR

			private static final long serialVersionUID = 1L;

			@Override
			protected CharSequence getChoiceCallbackUrl()
			{
				return choiceModelBehavior.getCallbackUrl();
			}

			@Override
			protected I indexToId(String index) {
				return handler.indexToId(index);
			}

			@Override
			protected String $()
			{
				if (templateBehavior != null)
				{
					// warning, the template text should be of the form <a>...</a> in order to work
					String render = "jQuery('%s').data('ui-autocomplete')._renderItem = function( ul, item ) { " // lf
							+ "var content = jQuery.tmpl(jQuery('#%s').html(), item);" // lf
							+ "return jQuery('<li/>').data('ui-autocomplete-item', item).append(content).appendTo(ul);" // lf
							+ "}";
					
					return super.$() + String.format(render, this.selector, templateBehavior.getToken());
				}

				return super.$();
			}

			@Override
			public void onConfigure(Component component) {
				super.onConfigure(component);
				if (preventSelectWhileQueryIsRunning) {
					// we define special functions in for handling select and fetch data
					this.setOption("select", "function(request, response) {\n" + getVarName() + ".select(request, response); \n}");
					if (this.isEnabled(component))
					{
						this.setOption("source",  "function(event, ui) {\n" + getVarName() + ".fetchItems(event, ui); \n}");
					}
				}
			}
		};
	}

	public void renderHead(IHeaderResponse response) {
		if (preventSelectWhileQueryIsRunning) {
			response.render(JavaScriptHeaderItem.forReference(JS));
			// we create a prototype with the data we need
			response.render(OnDomReadyHeaderItem.forScript(getVarName() + " = new WJQUI.AutoComplete('"
					+ getMarkupId() + "','" + choiceModelBehavior.getCallbackUrl()
					+ "', '" + autoCompleteBehavior.getOnSelectAjaxBehavior().getCallbackUrl() + "');"));
		}
	}

	private String getVarName() {
		return "window.aut_" + getMarkupId();
	}

	public AbstractAutoCompleteTextField<T, I> setPreventSelectWhileQueryIsRunning(boolean preventSelectWhileQueryIsRunning) {
		this.preventSelectWhileQueryIsRunning = preventSelectWhileQueryIsRunning;
		return this;
	}


	// Factories //

	/**
	 * Gets a new {@link IJQueryTemplate} to customize the rendering<br>
	 * The {@link IJQueryTemplate#getText()} should return a template text of the form "&lt;a&gt;...&lt;/a&gt;".<br>
	 * The properties used in the template text (ie: ${name}) should be identified in the list returned by {@link IJQueryTemplate#getTextProperties()}
	 *
	 * @return null by default
	 */
	protected IJQueryTemplate newTemplate()
	{
		return null;
	}

	protected abstract IAutoCompleteHandler<T, I> newHandler();

	/**
	 * Gets a new {@link IConverter}.<br>
	 * Used when the form component is posted and the bean type has been supplied to the constructor.
	 *
	 * @return the {@link IConverter}
	 */
	private IConverter<T> newConverter()
	{
		return new IConverter<>() { // NOSONAR

			private static final long serialVersionUID = 1L;

			@Override
			public T convertToObject(String value, Locale locale)
			{
				if (value != null && value.equals(AbstractAutoCompleteTextField.this.getModelValue()))
				{
					return AbstractAutoCompleteTextField.this.getModelObject();
				}

				return null; // if the TextField value (string) does not corresponds to the current object model (ie: user specific value), returns null.
			}

			@Override
			public String convertToString(T value, Locale locale)
			{
				return AbstractAutoCompleteTextField.this.renderer.getText(value);
			}
		};
	}

	/**
	 * Gets a new {@link AutoCompleteChoiceModelBehavior}
	 *
	 * @return the {@link AutoCompleteChoiceModelBehavior}
	 */
	private AutoCompleteChoiceModelBehavior<T, I> newChoiceModelBehavior()
	{
		return new AutoCompleteChoiceModelBehavior<>(this.renderer, this.template, this.handler) { // NOSONAR

			private static final long serialVersionUID = 1L;
			private static final String TERM = "term";

			@Override
			public List<T> getChoices()
			{
				final String input = RequestCycleUtils.getQueryParameterValue(TERM).toString();

				return handler.getChoices(input);
			}
		};
	}
}
