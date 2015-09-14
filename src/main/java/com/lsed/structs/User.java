/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.structs;

//import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Grady Ellison
 */
public class User implements Serializable
{
    
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String favoriteColor;
    private String favoriteActivity;
    //private List<String> categories;
    //private List<String> prerequisites;
    
    public User()
    {
        username = "";
        email = "";
        password = "";
        fullName = "";
        favoriteColor = "";
        favoriteActivity = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }
    
}
