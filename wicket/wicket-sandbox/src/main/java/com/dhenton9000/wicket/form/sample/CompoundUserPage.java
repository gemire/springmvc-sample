/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.form.sample;

 
import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dhenton
 */
public final class CompoundUserPage extends TemplatePage {
    
    private User user = new User();
    
    public CompoundUserPage() {
        super();
    }
    
    public CompoundUserPage(final PageParameters params) {
         this.setPageTitle("Compound Example - UserPage.html");
        add(new FeedbackPanel("feedback"));
        final TextField<String> tName = new TextField<String>("name");
	final TextField<Integer> tAge = new TextField<Integer>("age");
        final TextField<String> tNickname = new TextField<String>("nickName");
          
        tNickname.setConvertEmptyInputStringToNull(false);
        tName.setConvertEmptyInputStringToNull(false);
        tName.setRequired(false);
        tName.setRequired(false);
          
        Form<User> form = new Form<User>("compundUserForm") {
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
}
