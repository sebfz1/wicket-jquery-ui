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

import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode.UrlTreeNode;

/**
 * Provides a factory for building {@link TreeViewEvent}{@code s} as JSON, and vice-versa
 * 
 * @author Sebastien Briquet - sebfz1
 *
 */
public class TreeNodeFactory implements IClusterable
{
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TreeNodeFactory.class);

	/** node-id (also identifies the request parameter on ajax call */
	public static final String ID_FIELD = "nid";

	public static final String URL_FIELD = "url";
	public static final String TEXT_FIELD = "text";
	public static final String CHILDREN_FIELD = "hasChildren";

	/**
	 * Converts a {@link TreeViewEvent} to a {@link JSONObject}
	 *
	 * @param event the {@code TreeViewEvent}
	 * @return the {@code JSONObject}
	 */
	public JSONObject toJson(int index, TreeNode<?> node)
	{
		try
		{
			JSONObject json = new JSONObject();

			if (node != null)
			{
				json.put(ID_FIELD, node.getId());
				json.put(TEXT_FIELD, node.getText());
				json.put(CHILDREN_FIELD, node.hasChildren());

				if (node instanceof UrlTreeNode<?>)
				{
					json.put(URL_FIELD, ((UrlTreeNode<?>) node).getUrl());
				}
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
