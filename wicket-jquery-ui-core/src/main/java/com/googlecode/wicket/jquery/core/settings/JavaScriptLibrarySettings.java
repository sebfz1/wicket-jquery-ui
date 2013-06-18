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
package com.googlecode.wicket.jquery.core.settings;

import org.apache.wicket.request.resource.ResourceReference;

import com.googlecode.wicket.jquery.core.resource.JQueryResourceReference;

/**
 * Default implementation of {@link IJavaScriptLibrarySettings}.<br/>
 *
 * <code><pre>
 * public class MyApplication extends WebApplication
 * {
 *     public void init()
 *     {
 *         super.init();
 *
 *         IJQueryLibrarySettings settings = new JQueryLibrarySettings();
 *         settings.setJQueryReference(new PackageResourceReference(SampleApplication.class, "jquery-1.9.1.js"));
 *
 *         ApplicationJavaScriptLibrarySettings.set(settings);
 *     }
 * }
 * <pre></code>
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class JavaScriptLibrarySettings implements IJavaScriptLibrarySettings
{
	private ResourceReference jQueryReference = JQueryResourceReference.get();

	/**
	 * Constructor
	 */
	public JavaScriptLibrarySettings()
	{
	}

	// jQuery //
	@Override
	public ResourceReference getJQueryReference()
	{
		return this.jQueryReference;
	}

	@Override
	public void setJQueryReference(ResourceReference reference)
	{
		this.jQueryReference = reference;
	}
}
