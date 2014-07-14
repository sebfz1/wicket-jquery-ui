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
package com.googlecode.wicket.jquery.ui.widget.dialog;

import org.apache.wicket.markup.html.form.Form;

import com.googlecode.wicket.jquery.core.ajax.IJQueryAjaxAware;

/**
 * Provides the dialog-button's form-submit behavior
 *
 * @author Sebastien Briquet - sebfz1
 */
public class ButtonAjaxPostBehavior extends ButtonAjaxBehavior
{
	private static final long serialVersionUID = 1L;

	private final Form<?> form;

	/**
	 * Constructor
	 * @param source the {@link IJQueryAjaxAware}
	 * @param button the {@link DialogButton}
	 * @param form the {@link Form}
	 */
	public ButtonAjaxPostBehavior(IJQueryAjaxAware source, DialogButton button, Form<?> form)
	{
		super(source, button);

		this.form = form;
	}

	/**
	 * The formId may intentionally be null
	 */
	@Override
	public CharSequence getCallbackScript()
	{
		if (this.form != null)
		{
			final CharSequence script = String.format("wicketSubmitFormById('%s', '%s', null", this.form.getMarkupId(), this.getCallbackUrl());

			return this.generateCallbackScript(script) + ";return false";
		}

		return super.getCallbackScript();
	}
}
