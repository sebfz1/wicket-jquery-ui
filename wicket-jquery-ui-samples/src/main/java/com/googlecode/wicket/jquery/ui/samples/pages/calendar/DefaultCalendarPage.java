package com.googlecode.wicket.jquery.ui.samples.pages.calendar;

import org.apache.wicket.markup.html.panel.FeedbackPanel;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.calendar.Calendar;

public class DefaultCalendarPage extends AbstractCalendarPage
{
	private static final long serialVersionUID = 1L;

	public DefaultCalendarPage()
	{
		// FeedbackPanel //
		this.add(new FeedbackPanel("feedback"));

		// Calendar //
		Calendar calendar = new Calendar("calendar", new Options("theme", true));
		calendar.setGoogleCalendarApiKey(""); //FIXME correct KEY should be set here
		calendar.addFeed("qde8vmooe48vsm1ma3i9je88q8@group.calendar.google.com", "event-duchesse");
		this.add(calendar);
	}
}
