package com.googlecode.wicket.jquery.ui.samples.pages.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.util.ListModel;

import com.googlecode.wicket.jquery.ui.form.palette.Palette;
import com.googlecode.wicket.jquery.ui.samples.TemplatePage;

public class PalettePage extends TemplatePage
{
	private static final long serialVersionUID = 1L;

	public PalettePage()
	{
		final Form<Void> form = new Form<>("form");
		this.add(form);

		// Palette //
		final Palette<String> palette = new Palette<String>("palette", new ListModel<String>(new ArrayList<String>()), new ListModel<String>(Arrays.asList("1", "2", "3", "4")), new ChoiceRenderer<String>(), 6, true);
		form.add(palette);
	}
}
