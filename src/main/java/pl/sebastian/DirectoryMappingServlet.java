package pl.sebastian;

import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/one/directory/two/*")
public class DirectoryMappingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(RequestToHtmlConverter.convert(req));

        String requestUri = req.getRequestURI();
        String suffix = requestUri.replaceFirst(req.getContextPath() + "/one/directory/two/", "");
        out.println("<br>End of URI: " + suffix);
    }
}
