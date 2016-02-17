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

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.util.io.IClusterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a factory for building {@link TreeViewEvent}{@code s} as JSON, and vice-versa
 * 
 * @author Sebastien Briquet - sebfz1
 *
 */
public class TreeViewNodeFactory<T> implements IClusterable
{
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TreeViewNodeFactory.class);

	public static final String ID_FIELD = "id";
	public static final String TEXT_FIELD = "text";

	private final String idField;
	private final String textField;

	/**
	 * Factory class
	 */
	public TreeViewNodeFactory()
	{
//		this(ID_FIELD, TEXT_FIELD);
	}

//	/**
//	 * Factory class
//	 */
//	public TreeViewNodeFactory(String idField, String textField)
//	{
//		this.idField = idField;
//		this.textField = textField;
//	}
//
//	public String getIdField()
//	{
//		return this.idField;
//	}
//
//	public String getTextField()
//	{
//		return this.textField;
//	}

	/**
	 * Converts a {@link TreeViewEvent} to a {@link JSONObject}
	 *
	 * @param event the {@code TreeViewEvent}
	 * @return the {@code JSONObject}
	 */
	public JSONObject toJson(int index, T object)
	{
		try
		{
			JSONObject json = new JSONObject();

			if (object != null)
			{
				json.put(ID_FIELD, object.hashCode());
				json.put(TEXT_FIELD, object.toString());
			}

			return json;
		}
		catch (JSONException e)
		{
			LOG.error(e.getMessage(), e);
		}

		return null;
	}
}
