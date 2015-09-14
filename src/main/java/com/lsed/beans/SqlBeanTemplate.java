/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.beans;

import javax.annotation.Resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author comma
 */
public class SqlBeanTemplate {
    @Resource(lookup="jdbc/lsed_db")
    protected DataSource ds;
    protected Connection conn;
    
    public SqlBeanTemplate() throws SQLException
    {
        if (ds == null)
            throw new SQLException("DataSource is NULL in SqlBeanTemplate()");
        conn = ds.getConnection();
        if (conn == null)
            throw new SQLException("Cannot get connection from data source in SqlBeanTemplate()");
    }
    
    public ResultSet executeStatement(CallableStatement stmt) throws SQLException
    {
        if (stmt.execute())
            return stmt.getResultSet();
        return null;
    }
}
