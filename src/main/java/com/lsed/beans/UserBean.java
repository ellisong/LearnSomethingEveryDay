/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.lsed.structs.User;


/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "userBean", eager = true)
@ViewScoped
public class UserBean extends SqlBeanTemplate
{
    private List<User> users;
    
    public User userInput;
    
     /**
     * Creates a new instance of UserBean
     * @throws java.sql.SQLException
     */
    public UserBean() throws SQLException
    {
        users = null;
    }
    
    public List<User> getUsers() throws SQLException
    {
        //return getCardInfo_SortBy("Title");
        return users;
    }
    
    public void insertUserInfo(String username, String email, String passw, 
                               String fullName, String favoriteColor, 
                               String favoriteActivity) throws SQLException
    {
        CallableStatement stmt = conn.prepareCall("{CALL insertUserInfo(?, ?, ?, ?, ?, ?)}");
        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, passw);
        stmt.setString(4, fullName);
        stmt.setString(5, favoriteColor);
        stmt.setString(6, favoriteActivity);
        this.executeStatement(stmt);
    }

//    public List<User> getCardInfo_SortBy(String sortParam) throws SQLException
//    {
//        if (users == null) {
//            CallableStatement stmt = conn.prepareCall("{CALL queryCardInfo_SortBy(?)}");
//            stmt.setString(1, sortParam);
//            ResultSet rs = this.executeStatement(stmt);
//            if (rs != null) {
//                users = new ArrayList<>();
//                while (rs.next()) {
//                    User card = new User();
//
//                    card.setTitle(rs.getString("Title"));
//                    card.setDescription(rs.getString("Description"));
//                    card.setDateCreated(rs.getDate("DateCreated"));
//                    card.setDateModified(rs.getDate("DateModified"));
//                    card.setImageLink(rs.getString("ImageLink"));
//                    card.setEmbedLink(rs.getString("EmbedLink"));
//
//                    users.add(card);
//                }
//            }
//        }
//        return users;
//    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
