package pl.sebastian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"*.mp3", "*.mp4"})
public class ExtensionMatchingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestUri = req.getRequestURI();
        if (requestUri.endsWith("mp3")) {
            streamMP3(req, resp);
        } else {
            streamMP4(req, resp);
        }
    }

    private void streamMP4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String requestUri = req.getRequestURI();
        int lastSlash = requestUri.lastIndexOf("/");
        String filename = requestUri.substring(lastSlash + 1);
        out.println("Streaming MP4 file: " + filename);
    }

    private void streamMP3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("Jestem w streamMP3");
    }
}
