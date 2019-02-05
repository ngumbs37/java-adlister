import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Counter", urlPatterns = "/counter")
public class Counter extends HttpServlet {
    int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        counter++;
        String html = "<h1>Number of times visited: "+counter+"<h1>";

        res.getWriter().println(html);

    }

}

