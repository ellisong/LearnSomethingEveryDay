/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsed.database;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gra
 */
public class DatabaseConnectionTest
{
    
    public DatabaseConnectionTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of connectToMySqlDatabase method, of class DatabaseConnection.
     */
    @Test
    public void testConnectToMySqlDatabase() throws Exception
    {
        System.out.println("connectToMySqlDatabase");
        String connectionString = "";
        String username = "";
        String password = "";
        DatabaseConnection instance = new DatabaseConnection();
        instance.connectToMySqlDatabase(connectionString, username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeCardAndUserInfoToList method, of class DatabaseConnection.
     */
    @Test
    public void testWriteCardAndUserInfoToList() throws Exception
    {
        System.out.println("writeCardAndUserInfoToList");
        ArrayList<String> values = null;
        DatabaseConnection instance = new DatabaseConnection();
        instance.writeCardAndUserInfoToList(values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDatabaseConnectionString method, of class DatabaseConnection.
     */
    @Test
    public void testCreateDatabaseConnectionString()
    {
        System.out.println("createDatabaseConnectionString");
        String serverName = "";
        int port = 0;
        String database = "";
        String expResult = "";
        String result = DatabaseConnection.createDatabaseConnectionString(serverName, port, database);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasswordFromFile method, of class DatabaseConnection.
     */
    @Test
    public void testGetPasswordFromFile() throws Exception
    {
        System.out.println("getPasswordFromFile");
        String filePath = "";
        String expResult = "";
        String result = DatabaseConnection.getPasswordFromFile(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
