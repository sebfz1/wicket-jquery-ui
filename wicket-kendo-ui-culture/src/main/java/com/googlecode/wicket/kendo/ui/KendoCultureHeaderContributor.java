package com.googlecode.wicket.kendo.ui;

import java.util.Locale;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;

/**
 * IHeaderContributor to easily add {@link KendoCultureHeaderItem} to each page by using
 * 
 * <pre>
 * org.apache.wicket.Application#getHeaderContributorListeners().add(new KendoCultureHeaderContributor(Locale locale))
 * </pre>
 * Usage:
 *
 * <pre>
 * <code>
 * public class MyApplication extends WebApplication
 * {
 * 	public void init()
 * 	{
 * 		super.init();
 * 
 * 		getHeaderContributorListenerCollection().add(new KendoCultureHeaderContributor(Locale locale));
 *
 * 	}
 * }
 * </code>
 * </pre>
 * 
 * @author Patrick Davids - Patrick1701
 *
 */
public class KendoCultureHeaderContributor implements IHeaderContributor {
	private static final long serialVersionUID = 1L;
	
	private final Locale locale;
	
	public KendoCultureHeaderContributor(Locale locale) {
		this.locale = locale;
	}
	
	public void renderHead(IHeaderResponse response) {
		response.render(new KendoCultureHeaderItem(this.locale));
	}

}