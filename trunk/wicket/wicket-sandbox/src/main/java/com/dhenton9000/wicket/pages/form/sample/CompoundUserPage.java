/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.sample;

import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.StringValidator;

/**
 * This class demonstrates the use of a
 * {@link org.apache.wicket.model.CompoundPropertyModel} which will map the
 * items in form to the getters and setters of the Domain Object
 *
 * @author dhenton
 */
public final class CompoundUserPage extends TemplatePage {

    private User user = new User();

    public CompoundUserPage(final PageParameters params) {
        
        StringValidator bozoValidator = new BozoValidator();
        this.setPageTitle("Compound Example - UserPage.html");
        add(new FeedbackPanel("feedback"));
        final TextField<String> tName = new TextField<String>("name");
        final TextField<Integer> tAge = new TextField<Integer>("age");
        final TextField<String> tNickname = new TextField<String>("nickName");

        tNickname.setConvertEmptyInputStringToNull(false);
        tName.setConvertEmptyInputStringToNull(false);
        tName.setRequired(false);
        tName.setRequired(false);
        tName.add(bozoValidator);

        Form<User> form = new Form<User>("compoundUserForm",
                new CompoundPropertyModel<User>(user)) {
            @Override
            protected void onSubmit() {

                PageParameters pageParameters = new PageParameters();
                pageParameters.add("name", user.getName());
                pageParameters.add("age", Integer.toString(user.getAge()));
                pageParameters.add("nickName", user.getNickName());

                setResponsePage(SuccessPage.class, pageParameters);

            }
        };

        add(form);
        form.add(tName);
        form.add(tAge);
        form.add(tNickname);

    }
    
    class BozoValidator extends StringValidator {
       public ValidationError decorate(ValidationError error, 
               IValidatable<String> validatable) {
       error.addKey("mystringerror");
       return error;
    }
}
    
    
}
