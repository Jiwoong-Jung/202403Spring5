package todo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// TodoServlet.java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
    private Connection conn;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "mysql");
            System.out.println("접속완료");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM todos");

            List<Todo> todos = new ArrayList<>();
            while (rs.next()) {
                todos.add(new Todo(rs.getInt("id"), rs.getString("text")));
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(new Gson().toJson(todos));
            response.getWriter().write(todos.toString());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String text = request.getParameter("text");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO todos (text) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, text);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                response.getWriter().write(Integer.toString(id));
            }
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
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}