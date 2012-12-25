/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.form.sample;

import com.dhenton9000.wicket.TemplatePage;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.SimpleFormComponentLabel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
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
    private static final List<String> NUMBERS = Arrays.asList("1", "2", "3");

    public CompoundUserPage(final PageParameters params) {

        StringValidator bozoValidator = new BozoValidator();
        this.setPageTitle(this.getClass().getSimpleName());
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
                Integer i = user.getUserNumber();
                if (i == null) {
                    i = new Integer(0);
                }
                pageParameters.add("userNumber", Integer.toString(i));

                setResponsePage(SuccessPage.class, pageParameters);

            }
        };

        add(form);
        form.add(tName);
        form.add(tAge);
        form.add(tNickname);
        

        /////////////////////////////////////////////

//        RadioChoice<String> rc = 
//                new RadioChoice<String>("numberRadioChoice", 
//                NUMBERS).setSuffix("");
//        rc.setLabel(new Model<String>("number"));
//        rc.setRequired(true);
//        form.add(rc);

        RadioGroup<String> group = new RadioGroup<String>("userNumber");
        
        form.add(group);
        ListView<String> persons = new ListView<String>("numbers", NUMBERS) {
            @Override
            protected void populateItem(ListItem<String> item) {
                Radio<String> radio = new Radio<String>("radio", item.getModel());
                radio.setLabel(item.getModel());
                item.add(radio);
                item.add(new SimpleFormComponentLabel("number", radio));
            }
        }.setReuseItems(true);
        //  set the default in code, using the user object doesn't seem to work
          group.setModel(new Model<String>(NUMBERS.get(2)));
        group.add(persons);






    }

    class BozoValidator extends StringValidator {

        public ValidationError decorate(ValidationError error,
                IValidatable<String> validatable) {
            error.addKey("mystringerror");
            return error;
        }
    }
}
