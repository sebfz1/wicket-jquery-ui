package com.googlecode.wicket.jquery.ui.samples.pages.plugins;

import com.googlecode.wicket.jquery.ui.Options;
import com.googlecode.wicket.jquery.ui.plugins.SnippetBehavior;

public class DefaultSnippetPage extends AbstractSnippetPage
{
	private static final long serialVersionUID = 1L;
	
	public DefaultSnippetPage()
	{
		Options options = new Options();

		options.set("style", Options.asString("ide-eclipse"));
		
		this.add(new SnippetBehavior("#code", "java", options));
	}
}
