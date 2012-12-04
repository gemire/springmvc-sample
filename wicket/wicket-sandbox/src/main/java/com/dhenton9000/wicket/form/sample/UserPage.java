package com.dhenton9000.wicket.form.sample;

import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UserPage extends TemplatePage {

    private User user = new User();
    

    public UserPage(final PageParameters parameters) {

        
        
        this.setPageTitle("Wicket PropertyModel Example - UserPage.html");
        add(new FeedbackPanel("feedback"));

        final TextField<String> tName = new TextField<String>("name",
                new PropertyModel<String>(user, "name"));
        final TextField<Integer> tAge = new TextField<Integer>("age",
                new PropertyModel<Integer>(user, "age"));
        final TextField<String> tNickname = new TextField<String>("nickName",
                new PropertyModel<String>(user, "nickName"));
        tNickname.setConvertEmptyInputStringToNull(false);
        tName.setConvertEmptyInputStringToNull(false);
        tName.setRequired(false);
        tName.setRequired(false);
        
        
        Form<?> form = new Form<Void>("userForm") {
            @Override
            protected void onSubmit() {

                PageParameters pageParameters = new PageParameters();
                pageParameters.add("name", user.getName());
                pageParameters.add("age", Integer.toString(user.getAge()));
                pageParameters.add("nickname", user.getNickName());

                setResponsePage(SuccessPage.class, pageParameters);

            }
        };

        add(form);
        form.add(tName);
        form.add(tAge);
        form.add(tNickname);

    }

   
}
