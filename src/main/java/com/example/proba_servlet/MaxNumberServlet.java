package com.example.proba_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/maxNumberServlet", value = "/max-number-servlet")
public class MaxNumberServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/maxNumber.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String num3 = req.getParameter("num3");
        String state = req.getParameter("radioButton");

        String path = req.getContextPath();
        float result = 0;

        if(state.equals("max")){
            result = Math.max(Float.parseFloat(num3), (Math.max(Float.parseFloat(num1),
                    Float.parseFloat(num2))));
        }else if(state.equals("min")){
            result = Math.min(Float.parseFloat(num3), (Math.min(Float.parseFloat(num1),
                    Float.parseFloat(num2))));
        }else if(state.equals("average")){
            result = (Float.parseFloat(num1) + Float.parseFloat(num2) + Float.parseFloat(num3)) / 3;
        }

        out.println("<html><head>" +
                "<title>Цитата у Мартіна Фаулера</title>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">" +
                "</head><body>");
        out.println("<div class='container'>");
        out.println("<table class=\"table\">" +
                "<thead>" +
                "<tr>");
        out.println("<th scope=\"col\">Number first</th>" +
                    "<th scope=\"col\">Number second</th>" +
                    "<th scope=\"col\">Number third</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>" +
                "<tr>");
        out.println("<td>"+ num1 + "</td>" +
                    "<td>" + num2 + "</td>" +
                    "<td>" + num3 + "</td>" +
                "</tr>" +
                "<tr>" +
                    "<td></td>" +
                    "<th>" + state.toUpperCase() + ":</th>" +
                    "<td>" + result + "</td>" +
                "</tr>" +
                "</tbody>" +
                "</table>");
        out.println("<a href='" + path +"/max-number-servlet' class='btn btn-primary'>Повернутися</a>");
        out.println("</body></html>");
    }
}
