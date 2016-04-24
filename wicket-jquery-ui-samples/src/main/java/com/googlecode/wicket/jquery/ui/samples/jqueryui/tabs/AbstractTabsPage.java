package com.googlecode.wicket.jquery.ui.samples.jqueryui.tabs;

import java.util.Arrays;
import java.util.List;

import com.googlecode.wicket.jquery.ui.samples.JQuerySamplePage;

abstract class AbstractTabsPage extends JQuerySamplePage
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<DemoLink> getDemoLinks()
	{
		return Arrays.asList(new DemoLink(DefaultTabsPage.class, "Tabs Behavior"), new DemoLink(TabbedPanelPage.class, "TabbedPanel"), new DemoLink(AdvancedTabsPage.class, "TabbedPanel: demo"));
	}
}
