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
package com.googlecode.wicket.kendo.ui.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.CallbackParameter;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.string.StringValue;

import com.googlecode.wicket.jquery.core.JQueryEvent;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.ajax.IJQueryAjaxAware;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxBehavior;
import com.googlecode.wicket.jquery.core.utils.RequestCycleUtils;
import com.googlecode.wicket.kendo.ui.KendoUIBehavior;
import com.googlecode.wicket.kendo.ui.scheduler.resource.ResourceList;
import com.googlecode.wicket.kendo.ui.scheduler.resource.ResourceListModel;
import com.googlecode.wicket.kendo.ui.scheduler.views.SchedulerViewType;

/**
 * Provides the Kendo UI scheduler behavior
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public abstract class SchedulerBehavior extends KendoUIBehavior implements IJQueryAjaxAware, ISchedulerListener
{
	private static final long serialVersionUID = 1L;
	private static final JavaScriptResourceReference JS = new JavaScriptResourceReference(SchedulerBehavior.class, "SchedulerBehavior.js");

	static final String METHOD = "kendoScheduler";

	private final SchedulerDataSource dataSource;

	private JQueryAjaxBehavior onEditBehavior = null;
	private JQueryAjaxBehavior onNavigateBehavior;

	private JQueryAjaxBehavior onCreateBehavior;
	private JQueryAjaxBehavior onUpdateBehavior;
	private JQueryAjaxBehavior onDeleteBehavior;

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 */
	public SchedulerBehavior(final String selector)
	{
		this(selector, new Options());
	}

	/**
	 * Constructor
	 *
	 * @param selector the html selector (ie: "#myId")
	 * @param options the {@link Options}
	 */
	public SchedulerBehavior(final String selector, Options options)
	{
		super(selector, METHOD, options);

		this.dataSource = new SchedulerDataSource("schedulerDataSource");
		this.add(this.dataSource);
	}

	// Methods //

	@Override
	public void bind(Component component)
	{
		super.bind(component);

		// events //
		if (this.isEditEnabled())
		{
			component.add(this.onEditBehavior = this.newOnEditBehavior());
		}

		component.add(this.onNavigateBehavior = this.newOnNavigateBehavior());

		component.add(this.onCreateBehavior = this.newOnCreateBehavior());
		component.add(this.onUpdateBehavior = this.newOnUpdateBehavior());
		component.add(this.onDeleteBehavior = this.newOnDeleteBehavior());
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response)
	{
		super.renderHead(component, response);

		response.render(JavaScriptHeaderItem.forReference(JS));
	}

	// Properties //

	/**
	 * Gets the data-source behavior's url
	 *
	 * @return the data-source behavior's url
	 */
	protected abstract CharSequence getDataSourceUrl();

	/**
	 * Gets the <tt>ResourceListModel</tt>
	 *
	 * @return the {@link ResourceListModel}
	 */
	protected abstract ResourceListModel getResourceListModel();

	/**
	 * Gets the 'read' callback function<br/>
	 * As create, update and destroy need to be supplied, we should declare read as a function. Weird...
	 *
	 * @return the 'read' callback function
	 */
	private String getReadCallbackFunction()
	{
		String widget = this.widget(METHOD);
		String start = widget + ".view().startDate().getTime()";
		String end = String.format("calculateKendoSchedulerViewEndPeriod(%s.view().endDate()).getTime()", widget);

		return "function(options) {" // lf
				+ " jQuery.ajax({" // lf
				+ "		url: '" + this.getDataSourceUrl() + "'," // lf
				+ "		data: { start: " + start + ",  end: " + end + "}, " // lf
				+ "		dataType: 'json'," // lf
				+ "		success: function(result) {" // lf
				+ "			options.success(result);" // lf
				+ "		}," // lf
				+ "		error: function(result) {" // lf
				+ "			options.error(result);" // lf
				+ "		}" // lf
				+ "	});" // lf
				+ "}";
	}

	// Events //

	@Override
	public void onConfigure(Component component)
	{
		super.onConfigure(component);

		// options //
		this.setOption("autoBind", true);

		// events //
		if (this.onEditBehavior != null)
		{
			this.setOption("edit", this.onEditBehavior.getCallbackFunction());
		}

		this.setOption("navigate", this.onNavigateBehavior.getCallbackFunction());

		// data-source //
		this.setOption("dataSource", this.dataSource.getName());

		this.dataSource.setTransportRead(this.getReadCallbackFunction());
		this.dataSource.setTransportCreate(this.onCreateBehavior.getCallbackFunction());
		this.dataSource.setTransportUpdate(this.onUpdateBehavior.getCallbackFunction());
		this.dataSource.setTransportDelete(this.onDeleteBehavior.getCallbackFunction());

		// schema //
		// this.setOption("schema", new Options("timezone", Options.asString("Etc/UTC")));

		// resource //
		this.setOption("resources", this.getResourceListModel());
	}

	@Override
	public void onAjax(AjaxRequestTarget target, JQueryEvent event)
	{
		if (event instanceof NavigateEvent)
		{
			this.onNavigate(target, ((NavigateEvent) event).getView());
		}

		if (event instanceof SchedulerPayload)
		{
			SchedulerPayload payload = (SchedulerPayload) event;

			if (event instanceof EditEvent)
			{
				this.onEdit(target, payload.getEvent(), payload.getView());
			}

			if (event instanceof CreateEvent)
			{
				this.onCreate(target, payload.getEvent());
			}

			if (event instanceof UpdateEvent)
			{
				this.onUpdate(target, payload.getEvent());
			}

			if (event instanceof DeleteEvent)
			{
				this.onDelete(target, payload.getEvent());
			}
		}
	}

	// Factories //

	/**
	 * Gets the ajax behavior that will be triggered when when an event is edited
	 *
	 * @return the {@link JQueryAjaxBehavior}
	 */
	protected JQueryAjaxBehavior newOnEditBehavior()
	{
		return new JQueryAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			@Override
			protected CallbackParameter[] getCallbackParameters()
			{
				List<CallbackParameter> parameters = new ArrayList<CallbackParameter>();

				parameters.add(CallbackParameter.context("e"));

				// event //
				parameters.add(CallbackParameter.resolved("id", "e.event.id")); // retrieved
				parameters.add(CallbackParameter.resolved("title", "e.event.title")); // retrieved
				parameters.add(CallbackParameter.resolved("description", "e.event.description")); // retrieved

				parameters.add(CallbackParameter.resolved("start", "e.event.start.getTime()")); // retrieved
				parameters.add(CallbackParameter.resolved("end", "e.event.end.getTime()")); // retrieved
				parameters.add(CallbackParameter.resolved("isAllDay", "e.event.isAllDay")); // retrieved

				// recurrence //
				parameters.add(CallbackParameter.resolved("recurrenceId", "e.event.recurrenceId")); // retrieved
				parameters.add(CallbackParameter.resolved("recurrenceRule", "e.event.recurrenceRule")); // retrieved
				parameters.add(CallbackParameter.resolved("recurrenceException", "e.event.recurrenceException")); // retrieved

				// resources //
				for (String field : SchedulerBehavior.this.getResourceListModel().getFields())
				{
					parameters.add(CallbackParameter.resolved(field, String.format("jQuery.makeArray(e.event.%s)", field))); // retrieved
				}

				parameters.add(CallbackParameter.resolved("view", "e.sender.view().name")); // retrieved

				// view //
				return parameters.toArray(new CallbackParameter[] {});
			}

			@Override
			public CharSequence getCallbackFunctionBody(CallbackParameter... extraParameters)
			{
				return super.getCallbackFunctionBody(extraParameters) + " e.preventDefault();"; // avoid propagation of KendoUIs edit-event on client-side
			}

			@Override
			protected JQueryEvent newEvent()
			{
				return new EditEvent(SchedulerBehavior.this.getResourceListModel());
			}
		};
	}

	/**
	 * Gets the ajax behavior that will be triggered when is navigating in the scheduler
	 *
	 * @return the {@link JQueryAjaxBehavior}
	 */
	protected JQueryAjaxBehavior newOnNavigateBehavior()
	{
		return new JQueryAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			@Override
			protected CallbackParameter[] getCallbackParameters()
			{
				return new CallbackParameter[] { CallbackParameter.context("e"), CallbackParameter.resolved("view", "e.sender.view().name") };
			}

			@Override
			protected JQueryEvent newEvent()
			{
				return new NavigateEvent();
			}
		};
	}

	/**
	 * Gets the data-source's ajax behavior that will be triggered when an event is created
	 *
	 * @return the {@link JQueryAjaxBehavior}
	 */
	protected JQueryAjaxBehavior newOnCreateBehavior()
	{
		return new DataSourceAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			@Override
			protected JQueryEvent newEvent()
			{
				return new CreateEvent(SchedulerBehavior.this.getResourceListModel());
			}
		};
	}

	/**
	 * Gets the data-source's ajax behavior that will be triggered when an event is updated
	 *
	 * @return the {@link JQueryAjaxBehavior}
	 */
	protected JQueryAjaxBehavior newOnUpdateBehavior()
	{
		return new DataSourceAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			@Override
			protected JQueryEvent newEvent()
			{
				return new UpdateEvent(SchedulerBehavior.this.getResourceListModel());
			}
		};
	}

	/**
	 * Gets the data-source's ajax behavior that will be triggered when an event is deleted
	 *
	 * @return the {@link JQueryAjaxBehavior}
	 */
	protected JQueryAjaxBehavior newOnDeleteBehavior()
	{
		return new DataSourceAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			@Override
			protected JQueryEvent newEvent()
			{
				return new DeleteEvent(SchedulerBehavior.this.getResourceListModel());
			}
		};
	}

	// Event classes //

	/**
	 * Base class for data-source's ajax behavior
	 */
	private abstract class DataSourceAjaxBehavior extends JQueryAjaxBehavior
	{
		private static final long serialVersionUID = 1L;

		public DataSourceAjaxBehavior(IJQueryAjaxAware source)
		{
			super(source);
		}

		@Override
		protected CallbackParameter[] getCallbackParameters()
		{
			List<CallbackParameter> parameters = new ArrayList<CallbackParameter>();

			parameters.add(CallbackParameter.context("e"));

			// event //
			parameters.add(CallbackParameter.resolved("id", "e.data.id")); // retrieved
			parameters.add(CallbackParameter.resolved("title", "e.data.title")); // retrieved
			parameters.add(CallbackParameter.resolved("description", "e.data.description")); // retrieved

			parameters.add(CallbackParameter.resolved("start", "e.data.start.getTime()")); // retrieved
			parameters.add(CallbackParameter.resolved("end", "e.data.end.getTime()")); // retrieved
			parameters.add(CallbackParameter.resolved("isAllDay", "e.data.isAllDay")); // retrieved

			// recurrence //
			parameters.add(CallbackParameter.resolved("recurrenceId", "e.data.recurrenceId")); // retrieved
			parameters.add(CallbackParameter.resolved("recurrenceRule", "e.data.recurrenceRule")); // retrieved
			parameters.add(CallbackParameter.resolved("recurrenceException", "e.data.recurrenceException")); // retrieved

			// resources //
			for (String field : SchedulerBehavior.this.getResourceListModel().getFields())
			{
				parameters.add(CallbackParameter.resolved(field, "e.data." + field)); // retrieved
			}

			return parameters.toArray(new CallbackParameter[] {});
		}

		@Override
		public CharSequence getCallbackFunctionBody(CallbackParameter... extraParameters)
		{
			return super.getCallbackFunctionBody(extraParameters) + " e.success();";
		}
	}

	protected static class NavigateEvent extends JQueryEvent
	{
		private SchedulerViewType view = null;

		public NavigateEvent()
		{
			String view = RequestCycleUtils.getQueryParameterValue("view").toString();

			if (view != null)
			{
				this.view = SchedulerViewType.get(view);
			}
		}

		public SchedulerViewType getView()
		{
			return this.view;
		}
	}

	/**
	 * Base class for scheduler event payload
	 */
	protected static class SchedulerPayload extends JQueryEvent
	{
		private final SchedulerEvent event;
		private SchedulerViewType view = null;

		public SchedulerPayload(final ResourceListModel listModel)
		{
			int id = RequestCycleUtils.getQueryParameterValue("id").toInt();
			String title = RequestCycleUtils.getQueryParameterValue("title").toString();
			String description = RequestCycleUtils.getQueryParameterValue("description").toString();

			long start = RequestCycleUtils.getQueryParameterValue("start").toLong();
			long end = RequestCycleUtils.getQueryParameterValue("end").toLong();
			boolean allDay = RequestCycleUtils.getQueryParameterValue("isAllDay").toBoolean();

			String recurrenceId = RequestCycleUtils.getQueryParameterValue("recurrenceId").toString();
			String recurrenceRule = RequestCycleUtils.getQueryParameterValue("recurrenceRule").toString();
			String recurrenceException = RequestCycleUtils.getQueryParameterValue("recurrenceException").toString();

			this.event = new SchedulerEvent(id, title, start, end);
			this.event.setAllDay(allDay);
			this.event.setDescription(description);
			this.event.setRecurrenceId(recurrenceId);
			this.event.setRecurrenceRule(recurrenceRule);
			this.event.setRecurrenceException(recurrenceException);

			// Resources //
			Pattern pattern = Pattern.compile("([\\w-]+)");

			for (ResourceList list : listModel.getObject())
			{
				String field = list.getField();
				StringValue value = RequestCycleUtils.getQueryParameterValue(field);

				List<String> values = new ArrayList<String>();

				if (value != null)
				{
					Matcher matcher = pattern.matcher(value.toString());

					while (matcher.find())
					{
						values.add(matcher.group());
					}
				}

				if (list.isMultiple())
				{
					this.event.setResource(field, values);
				}
				else if (!values.isEmpty())
				{
					this.event.setResource(field, values.get(0)); // if the underlying value is a number (even a string-number), it will handled by Id#valueOf(I)
				}
			}

			// View //
			String view = RequestCycleUtils.getQueryParameterValue("view").toString();

			if (view != null)
			{
				this.view = SchedulerViewType.get(view);
			}
		}

		public SchedulerEvent getEvent()
		{
			return this.event;
		}

		public SchedulerViewType getView()
		{
			return this.view;
		}
	}

	protected static class EditEvent extends SchedulerPayload
	{
		public EditEvent(ResourceListModel listModel)
		{
			super(listModel);
		}
	}

	/**
	 * An event object that will be broadcasted when a scheduler event is created
	 */
	protected static class CreateEvent extends SchedulerPayload
	{
		public CreateEvent(ResourceListModel listModel)
		{
			super(listModel);
		}
	}

	/**
	 * An event object that will be broadcasted when a scheduler event is updated
	 */
	protected static class UpdateEvent extends SchedulerPayload
	{
		public UpdateEvent(ResourceListModel listModel)
		{
			super(listModel);
		}
	}

	/**
	 * An event object that will be broadcasted when a scheduler event is deleted
	 */
	protected static class DeleteEvent extends SchedulerPayload
	{
		public DeleteEvent(ResourceListModel listModel)
		{
			super(listModel);
		}
	}
}
