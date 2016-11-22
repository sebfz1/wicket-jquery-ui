package com.googlecode.wicket.kendo.ui;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;

import com.googlecode.wicket.jquery.core.utils.LocaleUtils;

/**
 * {@link IHeaderContributor} to automatically add the {@link KendoMessageHeaderItem} to each rendered page, using the specified culture.<br/>
 * If no culture is specified, the Session's Locale *culture* will be used. If that culture is invalid, the {@code IHeaderContributor} will not be rendered, providing a natural fallback to default widget's culture.<br/>
 * <br/>
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
 * 		this.getHeaderContributorListenerCollection().add(new KendoMessageHeaderContributor());
 * 	}
 * }
 * </code>
 * </pre>
 * 
 * @author Sebastien Briquet - sebfz1
 *
 */
public class KendoMessageHeaderContributor implements IHeaderContributor
{
	private static final long serialVersionUID = 1L;

	private final String culture;

	/**
	 * Constructor that will take the current {@link Session#getLocale()}
	 */
	public KendoMessageHeaderContributor()
	{
		this.culture = null;
	}

	/**
	 * Constructor
	 * 
	 * @param locale the {@link Locale}, ie: Locale.FRENCH
	 */
	public KendoMessageHeaderContributor(Locale locale)
	{
		this(LocaleUtils.getLangageCode(locale));
	}

	/**
	 * Constructor
	 * 
	 * @param culture the {@link KendoMessage}
	 */
	public KendoMessageHeaderContributor(KendoMessage culture)
	{
		this(culture.toString());
	}

	/**
	 * Constructor
	 * 
	 * @param culture the culture, ie: 'fr-FR'
	 */
	public KendoMessageHeaderContributor(String culture)
	{
		this.culture = culture;
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		final Locale locale = Session.get().getLocale();

		if (locale != null)
		{
			HeaderItem item = KendoMessageHeaderItem.of(this.culture, locale.toLanguageTag());

			if (item != null)
			{
				response.render(item);
			}
		}
	}
}
