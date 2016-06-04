package com.googlecode.wicket.jquery.ui.samples.jqueryui.tooltip;

import java.util.Arrays;
import java.util.List;

import com.googlecode.wicket.jquery.ui.samples.JQuerySamplePage;

abstract class AbstractTooltipPage extends JQuerySamplePage
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<DemoLink> getDemoLinks()
	{
		return Arrays.asList(new DemoLink(DefaultTooltipPage.class, "Tooltip behavior"), new DemoLink(CustomTooltipPage.class, "Custom tooltips"));
	}
}
