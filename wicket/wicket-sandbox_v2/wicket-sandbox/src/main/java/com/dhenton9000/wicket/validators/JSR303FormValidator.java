/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.validators;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;

/**
 *
 * @author dhenton
 */
public class JSR303FormValidator implements IFormValidator {

    @SpringBean
    protected Validator validator;
    private final FormComponent<?>[] components;

    public JSR303FormValidator(FormComponent<?>... components) {
        this.components = components;

    }

    @Override
    public FormComponent<?>[] getDependentFormComponents() {
        return this.components;
    }

    @Override
    public void validate(Form<?> form) {

        ConstraintViolation[] res = this.validator.validate(form.getModelObject()).toArray(new ConstraintViolation[0]);
        for (ConstraintViolation vio : res) {
            form.error(new ValidationError().setMessage(vio.getMessage()));
        }

    }
}