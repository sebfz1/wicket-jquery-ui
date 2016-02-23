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
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.JQueryEvent;
import com.googlecode.wicket.jquery.core.ajax.IJQueryAjaxAware;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxBehavior;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxPostBehavior;
import com.googlecode.wicket.jquery.core.event.IValueChangedListener;
import com.googlecode.wicket.kendo.ui.ajax.OnChangeAjaxBehavior;
import com.googlecode.wicket.kendo.ui.ajax.OnChangeAjaxBehavior.ChangeEvent;
import com.googlecode.wicket.kendo.ui.renderer.ChoiceRenderer;

/**
 * Provides a Kendo UI MultiSelect widget.<br/>
 * This ajax version will post the {@link Component}, using a {@link JQueryAjaxPostBehavior}, when the 'change' javascript method is called.
 *
 * @author Sebastien Briquet - sebfz1
 */
public abstract class AjaxMultiSelect<T> extends MultiSelect<T> implements IValueChangedListener
{
	private static final long serialVersionUID = 1L;

	public AjaxMultiSelect(String id)
	{
		super(id);
	}

	public AjaxMultiSelect(String id, IModel<? extends Collection<T>> model)
	{
		super(id, model);
	}

	public AjaxMultiSelect(String id, ChoiceRenderer<? super T> renderer)
	{
		super(id, renderer);
	}

	public AjaxMultiSelect(String id, IModel<? extends Collection<T>> model, ChoiceRenderer<? super T> renderer)
	{
		super(id, model, renderer);
	}

	// Events //

	@Override
	public void onValueChanged(AjaxRequestTarget target)
	{
		// noop
	}

	// IJQueryWidget //

	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new AjaxMultiSelectBehavior(selector) {

			private static final long serialVersionUID = 1L;

			// Events //

			@Override
			public void onValueChanged(AjaxRequestTarget target)
			{
				AjaxMultiSelect.this.processInput();
				AjaxMultiSelect.this.onValueChanged(target);
			}

			// Properties //

			@Override
			protected CharSequence getDataSourceUrl()
			{
				return AjaxMultiSelect.this.getCallbackUrl();
			}
		};
	}

	/**
	 * Provides a Ajax {@link MultiSelectBehavior}
	 */
	protected abstract static class AjaxMultiSelectBehavior extends MultiSelectBehavior implements IJQueryAjaxAware, IValueChangedListener
	{
		private static final long serialVersionUID = 1L;

		private JQueryAjaxBehavior onChangeAjaxBehavior = null;

		/**
		 * Constructor
		 *
		 * @param selector the html selector (ie: "#myId")
		 */
		public AjaxMultiSelectBehavior(String selector)
		{
			super(selector);
		}

		// Methods //

		@Override
		public void bind(Component component)
		{
			super.bind(component);

			if (component instanceof FormComponent<?>)
			{
				this.onChangeAjaxBehavior = new OnChangeAjaxBehavior(this, (FormComponent<?>) component);
				component.add(this.onChangeAjaxBehavior);
			}
			else
			{
				throw new WicketRuntimeException(new IllegalArgumentException("'component' should be an intance of FormComponent"));
			}
		}

		// Events //

		@Override
		public void onConfigure(Component component)
		{
			super.onConfigure(component);

			if (this.onChangeAjaxBehavior != null)
			{
				this.setOption("change", this.onChangeAjaxBehavior.getCallbackFunction());
			}
		}

		@Override
		public void onAjax(AjaxRequestTarget target, JQueryEvent event)
		{
			if (event instanceof ChangeEvent)
			{
				System.out.println("value: " + ((ChangeEvent) event).getValue()); // TODO remove
				this.onValueChanged(target);
			}
		}
	}
}
