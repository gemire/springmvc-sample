package com.dhenton9000.wicket.pages.form.sample;

import com.dhenton9000.wicket.pages.TemplatePage;
import com.dhenton9000.wicket.validators.NoHTMLValidator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class UserPage extends TemplatePage {
    
    private User user = new User();
    
    public UserPage(final PageParameters parameters) {
        
        
        
        this.setPageTitle(this.getClass().getSimpleName());
        add(new FeedbackPanel("feedback"));
        
        final TextField<String> tName = new TextField<String>("name",
                new PropertyModel<String>(user, "name"));
        final TextField<Integer> tAge = new TextField<Integer>("age",
                new PropertyModel<Integer>(user, "age"));
        final TextField<String> tNickname = new TextField<String>("nickName",
                new PropertyModel<String>(user, "nickName"));
        tNickname.setConvertEmptyInputStringToNull(false);
        tName.setConvertEmptyInputStringToNull(false);
        tName.setRequired(true);
        tName.add(new NoHTMLValidator());
        tNickname.setRequired(false);
        // using a Range Validator
        tAge.setRequired(true);
        tAge.add(new RangeValidator<Integer>(21, 125));
        //////////////////////////////////////////////
        
        
        Form<?> form = new Form<Void>("userForm") {
            @Override
            protected void onSubmit() {
                
                // this is a custom error validation item
                if (isABozo(user.getName())) {
                    
                    // the final parameter is the default message if no
                    // properties file found
                    String errMsg = getLocalizer().getString(
                            "bozo.errors.isABozo", UserPage.this,
                            "No bozos allowed default");
                    
                    error(errMsg);
                    
                    
                } else {
                    PageParameters pageParameters = new PageParameters();
                    pageParameters.add("name", user.getName());
                    pageParameters.add("age", Integer.toString(user.getAge()));
                    pageParameters.add("nickName", user.getNickName());
                    
                    setResponsePage(SuccessPage.class, pageParameters);
                }
                
            } // end on submit
        };
        
        add(form);
        form.add(tName);
        form.add(tAge);
        form.add(tNickname);
        
    }
    
    private boolean isABozo(String name) {
        
        if (name == null) {
            return false;
        }
        String test = name.trim().toUpperCase();
        
        
        if (test.indexOf("BOZO") > -1) {
            return true;
        } else {
            return false;
        }
    }
}
