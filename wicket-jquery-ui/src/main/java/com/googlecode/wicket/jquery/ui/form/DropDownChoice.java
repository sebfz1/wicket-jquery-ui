package com.googlecode.wicket.jquery.ui.form;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.CallbackParameter;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.IJQueryWidget;
import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.JQueryUIBehavior;

/**
 * Provides a jQuery selectmenu. It extends built-in {@link DropDownChoice}<br>
 * 
 * @param <T> the model object type
 * @author Patrick Davids - Patrick1701
 * 
 */
public class DropDownChoice<T> extends org.apache.wicket.markup.html.form.DropDownChoice<T> implements IJQueryWidget
{

	private static final long serialVersionUID = 1L;

	private AjaxFormComponentUpdatingBehavior onChangeBehavior;
	
	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public DropDownChoice(String id)
	{
		super(id);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param choices the collection of choices in the select menu
	 */
	public DropDownChoice(String id, List<? extends T> choices)
	{
		super(id, choices);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param choices the collection of choices in the select menu
	 * @param renderer the rendering engine
	 */
	public DropDownChoice(String id, List<? extends T> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, choices, renderer);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param choices the collection of choices in the select menu
	 */
	public DropDownChoice(String id, IModel<? extends List<? extends T>> choices)
	{
		super(id, choices);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param choices the collection of choices in the select menu
	 * @param renderer the rendering engine
	 */
	public DropDownChoice(String id, IModel<? extends List<? extends T>> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, choices, renderer);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the select menu
	 */
	public DropDownChoice(String id, IModel<T> model, List<? extends T> choices)
	{
		super(id, model, choices);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the select menu
	 * @param renderer the rendering engine
	 */
	public DropDownChoice(String id, IModel<T> model, List<? extends T> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, model, choices, renderer);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the select menu
	 */
	public DropDownChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices)
	{
		super(id, model, choices);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the select menu
	 * @param renderer the rendering engine
	 */
	public DropDownChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, model, choices, renderer);
	}

	/**
	 * We finally deny the built-in 'onSelectionChanged event handler' to be able to use the JQuery way.<br>
	 * To achieve ajaxified behavior add an {@link AjaxFormComponentUpdatingBehavior} <pre>dropDownChoice.add(new AjaxFormComponentUpdatingBehavior('change')))</pre>
	 * 
	 * @see AjaxFormComponentUpdatingBehavior
	 */
	@Override
	protected final boolean wantOnSelectionChangedNotifications() {
		return false;
	}
	
	/*
	 * determine the wicket-way of adding ajax-change-behavior and use it for selectmenu 'change' callback
	 */
	@Override
	public Component add(Behavior... behaviors) {
		for(Behavior b : behaviors){
			if(b instanceof AjaxFormComponentUpdatingBehavior){
				if(((AjaxFormComponentUpdatingBehavior) b).getEvent().endsWith("change")){
					this.onChangeBehavior = (AjaxFormComponentUpdatingBehavior)b;
				}
			}
		}
		return super.add(behaviors);
	}
	
	// Events //
	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(JQueryWidget.newWidgetBehavior(this)); // cannot be in ctor as the markupId may be set manually afterward
	}
	
	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		if(this.onChangeBehavior!=null){
			behavior.setOption("change", this.onChangeBehavior.getCallbackFunction(new CallbackParameter[] {}));
		}
	}

	@Override
	public void onBeforeRender(JQueryBehavior behavior)
	{
		// noop
	}

	// IJQueryWidget //
	@Override
	public SelectMenuBehavior newWidgetBehavior(String selector)
	{
		return new SelectMenuBehavior(selector);
	}

	/**
	 * Provides jQuery selectmenu {@link JQueryBehavior}
	 */
	public static class SelectMenuBehavior extends JQueryUIBehavior
	{
		private static final long serialVersionUID = 1L;
		private static final String METHOD = "selectmenu";

		public SelectMenuBehavior(String selector)
		{
			super(selector, METHOD);
		}

		public SelectMenuBehavior(String selector, Options options)
		{
			super(selector, METHOD, options);
		}
	}

}