/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "loginDisplayBean", eager = true)
@ViewScoped
public class LoginDisplayBean {
    private boolean login;
    private boolean signup;

    public LoginDisplayBean() {
        login = false;
        signup = false;
    }
    
    public boolean isLogin() {
        return login;
    }

    public boolean isSignup() {
        return signup;
    }
    
    public void viewLogin() {
        this.login = true;
        this.signup = false;
    }
    
    public void viewSignup() {
        this.login = false;
        this.signup = true;
    }
}
