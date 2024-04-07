package com.example.proba_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "/calculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        float num1 = Float.parseFloat(req.getParameter("num1"));
        float num2 = Float.parseFloat(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        String result = null;

        if("add".equals(operation)){
            result = String.valueOf(num1 + num2);
        }else if("subtract".equals(operation)){
            result = String.valueOf(num1 - num2);
        }else if("multiply".equals(operation)){
            result = String.valueOf(num1 * num2);
        }else if("divide".equals(operation)){
            if(num2 != 0){
                result = String.valueOf(num1 / num2);
            }else{
                result = "На нуль ділити не можна!";
            }
        }

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("operation", operation);
        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }
}
