/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.sql.CallableStatement;
import java.sql.SQLException;

import java.util.List;

import com.lsed.structs.User;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "userBean", eager = true)
@ViewScoped
public class UserBean
{
    @Resource(lookup="jdbc/lsed_db")
    protected DataSource ds;
    protected Connection conn;
    
    private List<User> users;
    
    public String username;
    public String password;
    public String fullName;
    public String favoriteColor;
    public String favoriteActivity;
    
     /**
     * Creates a new instance of UserBean
     * @throws java.sql.SQLException
     */
    public UserBean() throws SQLException
    {
        users = null;
        if (ds == null)
            throw new SQLException("DataSource is NULL in UserBean()");
        conn = ds.getConnection();
        if (conn == null)
            throw new SQLException("Cannot get connection from data source in UserBean()");
    }
    
    public List<User> getUsers() throws SQLException
    {
        //return getCardInfo_SortBy("Title");
        return users;
    }
    
    public void setUsers(List<User> users)
    {
        this.users = users;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
    public String submit() throws SQLException
    {
        CallableStatement stmt = conn.prepareCall("{CALL insertUserInfo(?, ?, ?, ?, ?)}");
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, fullName);
        stmt.setString(4, favoriteColor);
        stmt.setString(5, favoriteActivity);
        stmt.execute();
        return "success";
    }
}
