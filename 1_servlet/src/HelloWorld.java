import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author alpha
 * @date 2019.02
 */
@WebServlet(name = "HelloWorld", urlPatterns = "/")
public class HelloWorld extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /***************************************
         * 1、每次请求会创建一个新的线程
         * 2、新线程执行servlet的代码，servlet只有一个
         * 3、无状态：servlet不能有私有成员（状态），否则会出现多线程问题
         * *************************************/
        long id = Thread.currentThread().getId();
        int servletHashCode = this.hashCode();
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Hello World!</h1>");
        writer.write("<hr>");
        writer.write("<p>" + "servlet" + servletHashCode + "</p>");
        writer.write("<p>" + "current thread: " + id + "</p>");
    }
}
