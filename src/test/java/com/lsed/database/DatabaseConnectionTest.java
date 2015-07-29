///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.lsed.database;
//
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Rule;
//import org.junit.rules.ExpectedException;
//
///**
// *
// * @author Grady Ellison
// */
//public class DatabaseConnectionTest
//{
//    DatabaseConnection instance;
//    
//    public DatabaseConnectionTest()
//    {
//    }
//    
//    @BeforeClass
//    public static void setUpClass()
//    {
//    }
//    
//    @AfterClass
//    public static void tearDownClass()
//    {
//    }
//    
//    @Before
//    public void setUp()
//    {
//        instance = new DatabaseConnection();
//    }
//    
//    @After
//    public void tearDown()
//    {
//        instance = null;
//    }
//    
//    @Rule
//    public final ExpectedException exception = ExpectedException.none();
//    
//    @Test
//    public void createDatabaseConnectionString_NullParameters_ThrowsException() throws Exception
//    {
//        String serverName = "";
//        int port = 0;
//        String database = "";
//        exception.expect(IllegalArgumentException.class);
//        exception.reportMissingExceptionWithMessage("Test does not throw %s");
//        String result = DatabaseConnection.createDatabaseConnectionString(serverName, port, database);
//    }
//    
//    @Test
//    public void createDatabaseConnectionString_ValidParameters_ReturnsValidConnectionString()
//    {
//        String serverName = "127.0.0.1";
//        int port = 3306;
//        String database = "lsed_db";
//        String result = DatabaseConnection.createDatabaseConnectionString(serverName, port, database);
//        String expected = "jdbc:mysql://127.0.0.1:3306/lsed_db";
//        Assert.assertEquals("The returned value, " + result + ", does not match the expected value, " + expected, expected, result);
//    }
//    
//    @Test
//    public void createDatabaseConnectionString_NegativePortNumber_ThrowsException()
//    {
//        String serverName = "127.0.0.1";
//        int port = -250;
//        String database = "lsed_db";
//        exception.expect(IllegalArgumentException.class);
//        exception.reportMissingExceptionWithMessage("Test does not throw %s");
//        String result = DatabaseConnection.createDatabaseConnectionString(serverName, port, database);
//    }
//    
//    @Test
//    public void createDatabaseConnectionString_PortNumberGreaterThan65535_ThrowsException()
//    {
//        String serverName = "127.0.0.1";
//        int port = 69765;
//        String database = "lsed_db";
//        exception.expect(IllegalArgumentException.class);
//        exception.reportMissingExceptionWithMessage("Test does not throw %s");
//        String result = DatabaseConnection.createDatabaseConnectionString(serverName, port, database);
//    }
//    
//}
