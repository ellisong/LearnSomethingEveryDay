/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.validators;

import com.lsed.jpa.User;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author comma
 */
@FacesValidator("com.lsed.validators.SignupUsernameValidator")
public class signupUsernameValidator implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object value)
        throws ValidatorException 
    {
        String username = value.toString();
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "com.lsed.LearnSomethingEveryDay" );
        EntityManager em = emFactory.createEntityManager();
        Query qu = em.createNamedQuery("User.findByUsername");
        qu.setParameter("username", username);
        List<User> res = (List<User>)qu.getResultList();
        if (res.size() > 0) {
            throw new ValidatorException(new FacesMessage("That username is already taken. Please choose another username."));
        }
    }
}