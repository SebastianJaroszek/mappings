package pl.dominisz;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/welcome", "/hello", "/hi"})
public class ExactMatchingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String pathInfo = req.getPathInfo();
        String queryString = req.getQueryString();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Informacje o servlecie i requeście</h1>");
        out.println("requestURI = " + requestUri);
        out.println("<br>requestURL = " + requestUrl);
        out.println("<br>contextPath = " + contextPath);
        out.println("<br>pathInfo = " + pathInfo);
        out.println("<br>queryString = " + queryString);
    }

}
