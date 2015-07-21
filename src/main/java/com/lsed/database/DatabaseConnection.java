package com.lsed.database;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection
{
	private Connection conn;
	
	public DatabaseConnection()
	{
		this.conn = null;
	}
	
	public DatabaseConnection(String database, String username, String password, String serverName, Integer port) throws Exception
	{
		connectToMySqlDatabase(database, username, password, serverName, port);
	}
	
	public void connectToMySqlDatabase(String database, String username, String password, String serverName, Integer port) throws Exception
	{
		Connection connection = null;
		String connectionString = "jdbc:mysql://" + serverName + ":" + port.toString() + "/" + database;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(connectionString, username, password);
		this.conn = connection;
	}
	
	public void writeCardAndUserInfoToList(ArrayList<String> values) throws SQLException
	{
		PreparedStatement stmt = null;
		int fieldAmount = 6;
		String query = "SELECT CARD.Title, USER.Username, USER.Email, CARD.ImageLink, CARD.EmbedLink, CARD.Description FROM CARD INNER JOIN USER ON CARD.USER_UserId=USER.UserId";
		stmt = conn.prepareStatement(query);
		//stmt.setString(1, "CARD.USER_UserId");
		//stmt.setString(2, "USER.UserId");
		ResultSet rs = stmt.executeQuery();
		while (rs.next() == true) {
			for (int i = 1; i <= fieldAmount; i++)
				values.add(rs.getString(i));
		}
		if (stmt != null)
			stmt.close();
	}
	
	public static String getPasswordFromFile(String filePath) throws IOException
	{
		FileReader fr = null;
		BufferedReader reader = null;
		try {
			fr = new FileReader(filePath);
			reader = new BufferedReader(fr);
			String line = reader.readLine();
			if (reader != null)
				reader.close();
			if (fr != null)
				fr.close();
			return line;
		} catch (Exception e) {
			if (reader != null)
				reader.close();
			if (fr != null)
				fr.close();
			throw e;
		}
	}
}
