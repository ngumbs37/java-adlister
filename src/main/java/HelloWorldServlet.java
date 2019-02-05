import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("Hello World!");

        res.getWriter().println(hello(req.getParameter("name")));

    }
    public static String hello(){
        return "Hello, World!";
    }

    public static String hello(String name){
        if(name.length() >0)
            return "Hello, "+ name + "!";

        return hello();
    }
}
