/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author comma
 */
@FacesValidator("com.lsed.validators.SignupPasswordValidator")
public class signupPasswordValidator implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object value)
        throws ValidatorException 
    {
        String password = value.toString();

        UIInput uiPass = (UIInput) component.getAttributes().get("signupConfirmPassword");
        String confirmPassword = uiPass.getSubmittedValue().toString();

        if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            return;
        }

        if (!password.equals(confirmPassword)) {
              uiPass.setValid(false);
              throw new ValidatorException(new FacesMessage("Password must match confirm password."));
        }
    }
}