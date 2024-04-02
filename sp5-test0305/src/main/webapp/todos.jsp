<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- todos.jsp -->
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    <form action="/todos" method="post">
        <input name="text" type="text" placeholder="New task">
        <input type="submit" value="Add">
    </form>
    <ul>
        <% ResultSet todos = (ResultSet) request.getAttribute("todos"); %>
        <% while (todos.next()) { %>
            <li>
                <%= todos.getString("name") %>
                <form action="/todos" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="hidden" name="id" value="<%= todos.getString("id") %>">
                    <input type="submit" value="Delete">
                </form>
            </li>
        <% } %>
    </ul>
</body>
</html>