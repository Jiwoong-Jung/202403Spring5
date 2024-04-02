package servelet;
//TodoServlet.java
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

//@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
 private Connection conn;

 public void init() throws ServletException {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "root", "mysql");
     } catch (Exception e) {
         throw new ServletException(e);
     }
 }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM member");

         request.setAttribute("todos", rs);
         RequestDispatcher dispatcher = request.getRequestDispatcher("/todos.jsp");
         dispatcher.forward(request, response);
     } catch (SQLException e) {
         throw new ServletException(e);
     }
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         String text = request.getParameter("text");
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO todos (text) VALUES (?)");
         stmt.setString(1, text);
         stmt.executeUpdate();

         response.sendRedirect("/todos");
     } catch (SQLException e) {
         throw new ServletException(e);
     }
 }

 protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         int id = Integer.parseInt(request.getParameter("id"));
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM todos WHERE id = ?");
         stmt.setInt(1, id);
         stmt.executeUpdate();

         response.sendRedirect("/todos");
     } catch (SQLException e) {
         throw new ServletException(e);
     }
 }
}