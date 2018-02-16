package pl.sebastian;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestToHtmlConverter {

    /**
     * Metoda zwraca informacje o requeście w postaci opisu HTMLowego
     * request URI, request URL, context path, path info, query string
     *
     * @param request - request przychodzący do servletu
     * @return opis HTMLowy, zawierający informacje
     */
    public static String convert(HttpServletRequest request) {
        List<String> items = new ArrayList<>();
        items.add("requestURI = " + request.getRequestURI());
        items.add("requestURL = " + request.getRequestURL().toString());
        items.add("contextPath = " + request.getContextPath());
        items.add("pathInfo = " + request.getPathInfo());
        items.add("queryString = " + request.getQueryString());

        String result = "<h1>Informacje o servlecie i requeście</h1>";

        for (String item : items) {
            result = result + "<br>" + item;
        }

        return result;
    }

}
