/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.validators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author comma
 */
@FacesValidator("com.lsed.validators.EditCardImageLinkValidator")
public class editCardImageLinkValidator implements Validator
{
    String exceptionMessage = "If wanted, please enter a valid image URL with an image ending in: .bmp, .png, .jpg, .jpeg, or .gif";
    
    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object value)
        throws ValidatorException 
    {
        try {
            String link = value.toString();
            if (!link.isEmpty()) {
                URL url = new URL(link);
                URLConnection connection = url.openConnection();
                connection.connect();
                if (connection instanceof HttpURLConnection) {
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int code = httpConnection.getResponseCode();
                    if ((code >= 200) && (code < 400)) {
                        String urlString = url.toString();
                        if ((urlString.endsWith(".bmp")) || (urlString.endsWith(".png")) 
                             || (urlString.endsWith(".jpg")) 
                             || (urlString.endsWith(".jpeg")) 
                             || (urlString.endsWith(".gif"))) {
                        } else {
                            throw new ValidatorException(new FacesMessage(exceptionMessage));
                        }
                    } else {
                        throw new ValidatorException(new FacesMessage(exceptionMessage));
                    }
                } else {
                    throw new ValidatorException(new FacesMessage(exceptionMessage));
                }
            }
        } catch (MalformedURLException e) {
            throw new ValidatorException(new FacesMessage(exceptionMessage));
        } catch (IOException e) {
            throw new ValidatorException(new FacesMessage(exceptionMessage));
        }
    }
}