/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.repeater;

import com.dhenton9000.wicket.pages.TemplatePage;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.feedback.IFeedback;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class SimpleListViewRepeater extends TemplatePage {

    public SimpleListViewRepeater() {
        super();
        setup();
    }

    public SimpleListViewRepeater(PageParameters params) {
        setup();
    }

    private void setup() {
        this.setPageTitle(this.getClass().getSimpleName());
        final FeedbackPanel feedback = new FeedbackPanel("feedback");
        add(feedback);
        add(new InputForm("inputForm"));
    }
    
    
    
    /** form for processing the input. */
	private class InputForm extends Form
	{
		// holds NameWrapper elements
		private List data;

		public InputForm(String name)
		{
			super(name);
                        // add some dummy data
			data = new ArrayList();
			data.add(new NameWrapper("one"));
			data.add(new NameWrapper("two"));
			data.add(new NameWrapper("three"));
			data.add(new NameWrapper("four"));
			// add a nested list view; as the list is nested in the form, the form will
			// update all FormComponent childs automatically.
			ListView listView = new ListView("list", data)
			{
				protected void populateItem(ListItem item)
				{
					NameWrapper wrapper = (NameWrapper)item.getModelObject();
					item.add(new Label("name", wrapper.getName()));
					item.add(new CheckBox("check", new PropertyModel(wrapper, "selected")));
				}
			};
                        listView.setReuseItems(true);
                        add(listView);
		}

		public void onSubmit()
		{
			info("data: " + data); // print current contents
		}
	}
    
    
}
