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

import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.util.lang.Args;

/**
 * Provides the behavior that loads {@link SchedulerEvent}{@code s} according to {@link TreeViewModel} start &amp; end dates
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class TreeViewModelBehavior<T> extends AbstractAjaxBehavior
{
	private static final long serialVersionUID = 1L;

	private final TreeViewModel<T> model;
	private final TreeNodeFactory<T> factory;

	/**
	 * Constructor
	 *
	 * @param model the {@link TreeViewModel}
	 */
	public TreeViewModelBehavior(final TreeViewModel<T> model, TreeNodeFactory<T> factory)
	{
		this.model = model;
		this.factory = Args.notNull(factory, "factory");
	}

	// Properties //

	/**
	 * Sets the start date to the model<br/>
	 * This can be overridden to perform additional operation on date before the assignment.
	 *
	 * @param model the {@link TreeViewModel}
	 * @param date the timestamp
	 */
	protected void setModelNode(TreeViewModel<T> model, long nodeId)
	{
		model.setNodeId(nodeId);
	}

	public TreeNodeFactory<T> getFactory()
	{
		return this.factory;
	}

	// Events //

	@Override
	public void onRequest()
	{
		final RequestCycle requestCycle = RequestCycle.get();
		IRequestParameters parameters = requestCycle.getRequest().getQueryParameters();

		this.setModelNode(this.model, parameters.getParameterValue(TreeNodeFactory.ID_FIELD).toLong(0L));

		requestCycle.scheduleRequestHandlerAfterCurrent(this.newRequestHandler());
	}

	// Factories //

	/**
	 * Gets the new {@link IRequestHandler} that will respond the list of {@link SchedulerEvent} in a JSON format
	 *
	 * @return the {@link IRequestHandler}
	 */
	protected IRequestHandler newRequestHandler()
	{
		return new TreeViewModelRequestHandler();
	}

	// Classes //

	/**
	 * Provides the {@link IRequestHandler}
	 */
	protected class TreeViewModelRequestHandler implements IRequestHandler
	{
		@Override
		public void respond(final IRequestCycle requestCycle)
		{
			WebResponse response = (WebResponse) requestCycle.getResponse();

			final String encoding = Application.get().getRequestCycleSettings().getResponseRequestEncoding();
			response.setContentType("text/json; charset=" + encoding);
			response.disableCaching();

			if (model != null)
			{
				List<? extends TreeNode<T>> objects = model.getObject(); // calls load()

				if (objects != null)
				{
					StringBuilder builder = new StringBuilder("[ ");

					for (int index = 0; index < objects.size(); index++)
					{
						TreeNode<T> object = objects.get(index);

						// if (model instanceof ISchedulerVisitor)
						// {
						// event.accept((ISchedulerVisitor) model); // last chance to set options
						// }

						if (index > 0)
						{
							builder.append(", ");
						}

						builder.append(factory.toJson(index, object));
					}

					response.write(builder.append(" ]"));
				}
			}
		}

		@Override
		public void detach(final IRequestCycle requestCycle)
		{
			model.detach();
		}
	}
}
