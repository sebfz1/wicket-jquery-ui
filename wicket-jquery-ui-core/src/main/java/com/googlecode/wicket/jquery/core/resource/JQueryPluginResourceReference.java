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
package com.googlecode.wicket.jquery.core.resource;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.googlecode.wicket.jquery.core.settings.JQueryLibrarySettings;

/**
 * The resource reference for the jQuery UI javascript library.<br/>
 * To add a jQuery UI resource reference to a component, do not use this reference, but use
 * {@link JQueryLibrarySettings#getJQueryReference()} to prevent version conflicts.
 *TODO javadoc
 * @author Sebastien Briquet - sebfz1
 *
 */
public abstract class JQueryPluginResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	/**
	 * TODO javadoc
	 * @param scope
	 * @param name
	 */
	public JQueryPluginResourceReference(Class<?> scope, String name)
	{
		super(scope, name);
	}
}
