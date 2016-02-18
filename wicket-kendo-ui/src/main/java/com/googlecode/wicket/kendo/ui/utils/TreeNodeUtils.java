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
package com.googlecode.wicket.kendo.ui.utils;

import java.util.List;

import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;

public class TreeNodeUtils
{
	/**
	 * Utility class
	 */
	private TreeNodeUtils()
	{
		// noop
	}

	/**
	 * TODO javadoc
	 * 
	 * @param id
	 * @param nodes
	 * @return
	 */
	public static TreeNode<?> get(long id, List<TreeNode<?>> nodes)
	{
		for (TreeNode<?> node : nodes)
		{
			if (node.getId() == id)
			{
				return node;
			}
		}

		return null;
	}

	/**
	 * TODO javadoc
	 * 
	 * @param parentId
	 * @param nodes
	 * @return
	 */
	public static List<? extends TreeNode<?>> getChildren(long parentId, List<TreeNode<?>> nodes)
	{
		List<TreeNode<?>> list = Generics.newArrayList();

		for (TreeNode<?> node : nodes)
		{
			if (node.getParentId() == parentId)
			{
				list.add(node);
			}
		}

		return list;
	}
}
