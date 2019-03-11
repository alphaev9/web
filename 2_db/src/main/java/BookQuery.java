import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BookQuery", urlPatterns = "/query")
public class BookQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test");
            PreparedStatement ps = connection.prepareStatement("SELECT title,press FROM test.books WHERE author=?");
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();

            PrintWriter writer = response.getWriter();
            writer.write("<h1>The books written by " + author + "</h1>");
            writer.write("<hr>");

            if (!rs.wasNull()) {
                writer.write(" <table>\n" +
                        "     <tr>\n" +
                        "         <th>Title</th>\n" +
                        "         <th>Press</th>\n" +
                        "     </tr>");
            }
            while (rs.next()) {
                String title = rs.getString("title");
                String press = rs.getString("press");
                writer.write("<tr>\n" +
                        "<td>" + title + "</td>\n" +
                        "<td>" + press + "</td>\n" +
                        "</tr>");
            }

            writer.write("</table>");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
