<%@page import="java.nio.file.Paths"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.lsed.database.DatabaseConnection" %>
<%@ page import="com.lsed.formatter.TableDrawer" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/normalize.css"/>
	<link rel="stylesheet" type="text/css" href="./css/main.css"/>
	<title>Learn Something Every Day!</title>
</head>
<body>
    <%= request.getContextPath() %>
	<%
        //String pass = DatabaseConnection.getPasswordFromFile("/home/commlaptop/sql.txt");
        String pass = DatabaseConnection.getPasswordFromFile("D:/projects/LearnSomethingEveryDay/sql.txt");
        DatabaseConnection db = new DatabaseConnection("lsed_db", "guest", pass, "localhost", 3306);

        TableDrawer td = new TableDrawer();
        ArrayList<String> values = new ArrayList<String>();

        int columns = 6;
        values.add("<b><h4>CARD.Title</h4></b>");
        values.add("<b><h4>USER.Username</h4></b>");
        values.add("<b><h4>USER.Email</h4></b>");
        values.add("<b><h4>CARD.ImageLink</h4></b>");
        values.add("<b><h4>CARD.EmbedLink</h4></b>");
        values.add("<b><h4>CARD.Description</h4></b>");
        db.writeCardAndUserInfoToList(values);

        td.drawTable(values.size() / columns, columns, values, "width:100%");
        out.println(td.getOutput());
        %>
</body>
</html>