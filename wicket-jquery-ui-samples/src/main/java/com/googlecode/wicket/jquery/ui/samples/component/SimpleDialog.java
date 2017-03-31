package com.googlecode.wicket.jquery.ui.samples.component;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.Model;

import com.googlecode.wicket.jquery.ui.form.DropDownChoice;
import com.googlecode.wicket.jquery.ui.widget.dialog.AbstractDialog;
import com.googlecode.wicket.jquery.ui.widget.dialog.DialogButton;
import com.googlecode.wicket.jquery.ui.widget.dialog.DialogButtons;

public abstract class SimpleDialog extends AbstractDialog<String>
{
	private static final long serialVersionUID = 1L;

	private final DropDownChoice<String> dropDownChoice;
	public SimpleDialog(String id, String title, Model<String> model)
	{
		super(id, title, model, true);
		
		dropDownChoice = new DropDownChoice<String>("dropDownChoice", Arrays.asList(new String[]{ "Hamburg", "Paris", "New York" }));
		dropDownChoice.setOutputMarkupId(true);
		
		add(dropDownChoice);
	}

	@Override
	protected void onOpen(AjaxRequestTarget target) {
		
		//adding the DropDownChoice to the AjaxRequestTarget onOpen
		//AND DialogBehaviors open()-method uses  target.prependJavaScript(this.$(Options.asString("open")));
		//then the SelectMenu does not collaps, because its visible an can be re-initialized / re-calculated.

		//So, I have three problems:
		//1. The need of re-init the selectmenu, caused by the 'hidden-problem' which occurs in dialogs and accordions.
		//2. The need of changing the DialogBehavior to prependJavascript(), what only fixes this problem in dialogs and not in common.
		//3. I think this is really more a JQueryUI Problem, but the bug was not accepted. https://bugs.jqueryui.com/ticket/14825
		
		//target.add(dropDownChoice);
	}
	
	@Override
	public boolean isResizable()
	{
		return true;
	}

	@Override
	protected List<DialogButton> getButtons()
	{
		return DialogButtons.OK_CANCEL.toList(); //this syntax is allowed until the button state (enable and/or visible) is not altered
	}
}