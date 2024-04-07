package com.example.proba_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "/analiseTextServlet", value = "/analise-text-servlet")
public class AnaliseTextServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/analiseText.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String text = req.getParameter("text");
        String countOfVowel = String.valueOf(getVowelOfText(text));
        String listOfVowel = getListOfVowel(text);
        String countOfConsonant = String.valueOf(getConsonantOfText(text));
        String listOfConsonant = getListOfConsonant(text);
        String countOfPunctuation = String.valueOf(getPunctuationOfText(text));
        String listOfPunctuation = getListOfPunctuation(text);

        //if use <c:if> but site will update
        req.setAttribute("text", text);
        req.setAttribute("countOfVowel", countOfVowel);
        req.setAttribute("listOfVowel", listOfVowel);
        req.setAttribute("countOfConsonant", countOfConsonant);
        req.setAttribute("listOfConsonant", listOfConsonant);
        req.setAttribute("countOfPunctuation", countOfPunctuation);
        req.setAttribute("listOfPunctuation", listOfPunctuation);

        getServletContext().getRequestDispatcher("/analiseText.jsp").forward(req, resp);

        //if use dynamic add info
//        PrintWriter out = resp.getWriter();
//
//        out.println("<p>Аналізований текст: " + countOfVowel + "</p>");
    }

    private long getVowelOfText(String text){
        return text.chars() // Перетворюємо рядок у IntStream
                .mapToObj(c -> (char) c) // Перетворюємо IntStream у Stream<Character>
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1) // Фільтруємо голосні
                .count();
    }

    private String getListOfVowel(String text){
        return text.chars() // Перетворюємо рядок у IntStream
                .mapToObj(c -> (char) c) // Перетворюємо IntStream у Stream<Character>
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1) // Фільтруємо голосні
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private long getConsonantOfText(String text){
        return text.chars() // Перетворюємо рядок у IntStream
                .mapToObj(c -> (char) c) // Перетворюємо IntStream у Stream<Character>
                .filter(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) // Переконуємось, що символ є літерою
                .filter(c -> !"AEIOUaeiou".contains(String.valueOf((char)c))) // Виключаємо голосні
                .count();
    }

    private String getListOfConsonant(String text){
        return text.chars() // Перетворюємо рядок у IntStream
                .mapToObj(c -> (char) c) // Перетворюємо IntStream у Stream<Character>
                .filter(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) // Переконуємось, що символ є літерою
                .filter(c -> !"AEIOUaeiou".contains(String.valueOf((char)c))) // Виключаємо голосні
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private long getPunctuationOfText(String text){
        return text.chars()
                .filter(c -> ",.?!;:'\"()-{}".indexOf(c) != -1) // Перевіряємо, чи символ є розділовим знаком
                .count(); // Підрахунок кількості розділових знаків
    }

    private String getListOfPunctuation(String text){
        return text.chars()
                .mapToObj(c -> (char) c) // Перетворюємо IntStream у Stream<Character>
                .filter(c -> ",.?!;:'\"()-{}".indexOf(c) != -1) // Перевіряємо, чи символ є розділовим знаком
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
