package com.googlecode.wicket.jquery.ui.kendo.editor;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.ui.IJQueryWidget;
import com.googlecode.wicket.jquery.ui.JQueryBehavior;
import com.googlecode.wicket.jquery.ui.Options;
import com.googlecode.wicket.jquery.ui.kendo.KendoAbstractBehavior;

public class Editor<T> extends TextArea<T> implements IJQueryWidget
{
	private static final long serialVersionUID = 1L;
	private static final String METHOD = "kendoEditor";
	
	private final Options options;

	public Editor(String id)
	{
		this(id, new Options());
	}

	public Editor(String id, Options options)
	{
		super(id);
		
		this.options = options;
	}

	public Editor(String id, IModel<T> model)
	{
		this(id, model, new Options());
	}

	public Editor(String id, IModel<T> model, Options options)
	{
		super(id, model);
		
		this.options = options;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(JQueryWidget.newWidgetBehavior(this));
	}
	

	/**
	 * TODO: javadoc
	 * @param behavior
	 */
	protected void onConfigure(JQueryBehavior behavior)
	{
		behavior.setOptions(this.options);
	}

	// IJQueryWidget //
	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new KendoAbstractBehavior(selector, Editor.METHOD) {

			private static final long serialVersionUID = 1L;

			@Override
			public void onConfigure(Component component)
			{
				Editor.this.onConfigure(this);
			}
		};
	}

}
