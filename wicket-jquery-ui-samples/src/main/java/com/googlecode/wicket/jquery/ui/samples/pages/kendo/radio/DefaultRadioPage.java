package com.googlecode.wicket.jquery.ui.samples.pages.kendo.radio;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioGroup;

import com.googlecode.wicket.kendo.ui.form.Radio;
import com.googlecode.wicket.kendo.ui.form.Radio.Label;
import com.googlecode.wicket.kendo.ui.form.button.AjaxButton;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

public class DefaultRadioPage extends AbstractRadioPage
{
    private static final long serialVersionUID = 1L;

    public DefaultRadioPage(){
        
        // Radio //
        RadioGroup<String> group = new RadioGroup<String>("radiogroup");
        this.add(group);

        Radio<String> radio1 = new Radio<String>("radio1", group);
        group.add(radio1);
        Label label1 = new Label("label1", "Radio1", radio1);
        group.add(label1);

        Radio<String> radio11 = new Radio<String>("radio11", group);
        group.add(radio11);
        Label label11 = new Label("label11", "Radio11", radio11);
        group.add(label11);

        Radio<String> radio2 = new Radio<String>("radio2", group);
        group.add(radio2.setEnabled(false));

        Label label2 = new Label("label2", "Radio2", radio2);
        group.add(label2);

        // Feedback //
        final KendoFeedbackPanel feedback = new KendoFeedbackPanel("feedback");
        this.add(feedback);

        // Form //
        final Form<Void> form = new Form<Void>("form");
        this.add(form);

        // Buttons //
        form.add(new AjaxButton("show") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

                this.info("Simple message");

                target.add(feedback);
            }
        });

    }
}
