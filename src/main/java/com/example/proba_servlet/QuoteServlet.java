package com.example.proba_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/quoteServlet", value = "/quote-servlet")
public class QuoteServlet extends HttpServlet {
    String quote;

    @Override
    public void init() throws ServletException {
        quote = "Bad programmers worry about the code. Good programmers worry about data structures and their " +
                "relationships";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Встановлення типу вмісту відповіді на HTML
        resp.setContentType("text/html");

        // Отримання потоку для запису відповіді
        PrintWriter out = resp.getWriter();

        String path = req.getContextPath();

        // Виведення HTML з цитатою
        out.println("<html><head>" +
                "<title>Цитата у Мартіна Фаулера</title>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">" +
                "</head><body>");
        out.println("<html><body>");
        out.println("<div class='container'>");
        out.println("<h1>Цитата Лінуса Торвальдса:</h1>");
        out.println("<p>" + quote + "</p>");
        out.println("<a href='" + path + "' class='btn btn-outline-primary'>Повернутися</a>");
        out.println("</div>");
        out.println("</body></header></html>");
    }
}
