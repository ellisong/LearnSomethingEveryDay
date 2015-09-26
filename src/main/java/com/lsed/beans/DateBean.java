/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Grady Ellison
 */
@ManagedBean(name = "dateBean", eager = true)
@ViewScoped
public class DateBean
{
    public Date date;
    private final SimpleDateFormat df;
    
    public DateBean() {
        this.date = new Date();
        this.df = new SimpleDateFormat("MM-dd-yyyy");
    }
    
    public String getDate() {
        return df.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
