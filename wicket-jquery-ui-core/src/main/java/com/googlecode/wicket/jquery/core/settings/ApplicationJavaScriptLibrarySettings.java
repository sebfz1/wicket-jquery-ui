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


/**
 * Provides an alternative to WebApplication#setJavaScriptLibrarySettings (wicket6).<br/>
 *
 * <code><pre>
 * public class MyApplication extends WebApplication
 * {
 *     public void init()
 *     {
 *         super.init();
 *
 *         IJQueryLibrarySettings settings = new JQueryLibrarySettings();
 *         settings.setJQueryReference(new PackageResourceReference(SampleApplication.class, "jquery-1.9.1.js"));	// jQuery
 *         settings.setJQueryGlobalizeReference(JQueryGlobalizeResourceReference.get());							// jQuery Globalize
 *
 *         ApplicationJavaScriptLibrarySettings.set(settings);
 *     }
 * }
 * <pre></code>
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class ApplicationJavaScriptLibrarySettings
{
	private static IJavaScriptLibrarySettings settings = null;

	/**
	 * Gets the {@link IJavaScriptLibrarySettings}
	 * @return the {@link IJavaScriptLibrarySettings}
	 */
	public static IJavaScriptLibrarySettings get()
	{
		return ApplicationJavaScriptLibrarySettings.settings;
	}

	/**
	 * Sets the {@link IJavaScriptLibrarySettings}
	 * @param settings the {@link IJavaScriptLibrarySettings}
	 */
	public static void set(IJavaScriptLibrarySettings settings)
	{
		ApplicationJavaScriptLibrarySettings.settings = settings;
	}

	/**
	 * Static class
	 */
	private ApplicationJavaScriptLibrarySettings()
	{
	}
}
