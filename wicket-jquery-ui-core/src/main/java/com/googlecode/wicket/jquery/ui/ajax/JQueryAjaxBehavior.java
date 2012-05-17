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
package com.googlecode.wicket.jquery.ui.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEventSink;
import org.apache.wicket.util.time.Duration;

import com.googlecode.wicket.jquery.ui.JQueryEvent;

/**
 * Base class for implementing AJAX GET calls on JQuery components<br />
 * The 'source' constructor argument is the {@link Component} to which the event returned by {@link #newEvent(AjaxRequestTarget)} will be broadcasted.<br/>
 * <pre>
public class MyJQueryLabel extends Label implements IJQueryWidget
{
	private static final long serialVersionUID = 1L;

	// Mainly used to cast to the exact type
	class MyEvent extends JQueryEvent
	{
		public MyEvent(AjaxRequestTarget target)
		{
			super(target);
		}
	}

	private JQueryAjaxBehavior ajaxBehavior;

	public MyJQueryLabel(String id)
	{
		super(id);
		this.init();
	}

	private void init()
	{
		this.ajaxBehavior = new JQueryAjaxBehavior(this) {

			private static final long serialVersionUID = 1L;

			protected JQueryEvent newEvent(AjaxRequestTarget target)
			{
				return new MyEvent(target);
			}
		};
	}

	public void onEvent(IEvent<?> event)
	{
		if (event.getPayload() instanceof MyEvent)
		{
			JQueryEvent payload = (JQueryEvent) event.getPayload();
			AjaxRequestTarget target = payload.getTarget();
			//do something with the target
		}
	}
	
	protected void onInitialize()
	{
		super.onInitialize();
		
		this.add(this.ajaxBehavior);
		this.add(JQueryWidget.newWidgetBehavior(this));
	}	

	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new JQueryBehavior(selector, "jquerymethod") {

			private static final long serialVersionUID = 1L;

			public void onConfigure(Component component)
			{
				this.setOption("jqueryevent", "function( event, ui ) { " + ajaxBehavior.getCallbackScript() + " }");
			}
		};
	}
}
 * </pre>
 * 
 * @author Sebastien Briquet - sebastien@7thweb.net
 *
 */
public abstract class JQueryAjaxBehavior extends AbstractDefaultAjaxBehavior
{
	private static final long serialVersionUID = 1L;

	private final Component source;
	private final Duration duration;
	
	/**
	 * Constructor
	 * @param source {@link Component} to which the event returned by {@link #newEvent(AjaxRequestTarget)} will be broadcasted.
	 */
	public JQueryAjaxBehavior(Component source)
	{
		this(source, Duration.NONE);
	}

	/**
	 * Constructor
	 * @param source {@link Component} to which the event returned by {@link #newEvent(AjaxRequestTarget)} will be broadcasted.
	 * @param duration {@link Duration}. If different than {@link Duration#NONE}, an {@link AjaxCallThrottlingDecorator} will be added with the specified {@link Duration}.
	 */
	public JQueryAjaxBehavior(Component source, Duration duration)
	{
		this.source = source;
		this.duration = duration;
	}

	@Override
	protected void respond(AjaxRequestTarget target)
	{
		this.source.send(this.getSink(), this.getBroadcast(), this.newEvent(target));
	}

	/**
	 * Gets the broadcast to be used in {@link #respond(AjaxRequestTarget)}
	 * @return {@link Broadcast#EXACT} by default
	 */
	protected Broadcast getBroadcast()
	{
		return Broadcast.EXACT;
	}

	/**
	 * Gets the sink (the object that will receive the event).<br/>
	 * This method might be overridden if the {@link #getBroadcast()} is overridden.
	 * @return by default, the source component specified in the constructor.
	 */
	protected IEventSink getSink()
	{
		return this.source;
	}
	
	//promote visibility
	/**
	 * @deprecated the visibility has changed to public
	 */
	@Override
	public String getCallbackFunction(String... extraParameters)
	{
		return super.getCallbackFunction(extraParameters).toString();
	}
	
	/**
	 * Special implementation where supplied extraParameters are of the form { 'param1': param2, 'param3': param4 }
	 * @deprecated use the new built-in implementation
	 */
	@Override
	protected CharSequence getCallbackFunctionBody(String... extraParameters)
	{
		AjaxRequestAttributes attributes = getAttributes();
		CharSequence attrsJson = renderAjaxAttributes(getComponent(), attributes);
		
		StringBuilder builder = new StringBuilder();
		builder.append("var attrs = ").append(attrsJson).append(";\n");

		builder.append("var params = {");
		
		if (extraParameters.length % 2 == 0)
		{
			for (int i = 0; i < extraParameters.length - 1; i += 2)
			{
				if (i > 0)
				{
					builder.append(", ");
				}
				
				builder.append("'").append(extraParameters[i]).append("': ").append(extraParameters[i + 1]);
			}
		}

		builder.append("};\n");
		
		if (attributes.getExtraParameters().isEmpty())
		{
			builder.append("attrs.ep = params;\n");
		}
		else
		{
			builder.append("attrs.ep = jQuery.extend({}, attrs.ep, params);\n");
		}
		
		builder.append("Wicket.Ajax.ajax(attrs);\n");
		return builder;
	}
	
	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		super.updateAjaxAttributes(attributes);
		
		if (this.duration != Duration.NONE)
		{
			attributes.setThrottlingSettings(new ThrottlingSettings("jquery-throttle", this.duration));
		}
	}

	/**
	 * @param target the {@link AjaxRequestTarget}
	 * @return the {@link JQueryEvent} to be broadcasted to the source when the behavior will respond
	 */
	protected abstract JQueryEvent newEvent(AjaxRequestTarget target);	
}
