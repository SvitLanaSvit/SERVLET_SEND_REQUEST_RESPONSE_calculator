<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Svitlana
  Date: 07.04.2024
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
  <body>
    <div class="container">
      <form id="analysisForm" method="post" action="analise-text-servlet">

        <div class="mb-3">
          <label for="text">Text:</label>
          <textarea class="form-control" placeholder="Leave a text here" id="text" name="text" rows="10"></textarea>
        </div>

        <div class="btn-group">
          <button type="submit" name="submit" class="btn btn-primary">Проаналізувати</button>
          <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Повернутися</a>
        </div>
      </form>

      <c:if test="${not empty countOfVowel}">
        <h2>Результати аналізу до тексту:</h2>
        <p>${text}</p>
        <table class="table table-hover table-striped">
          <thead>
          <tr>
            <th scope="col">Кількість голосних</th>
            <th scope="col">Список голосних</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>${countOfVowel}</td>
            <td>${listOfVowel}</td>
          </tr>
          </tbody>
        </table>
      </c:if>

      <c:if test="${not empty countOfConsonant}">
        <table class="table table-hover table-striped">
          <thead>
          <tr>
            <th scope="col">Кількість приголосних</th>
            <th scope="col">Список приголосних</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>${countOfConsonant}</td>
            <td>${listOfConsonant}</td>
          </tr>
          </tbody>
        </table>
      </c:if>

      <c:if test="${not empty countOfPunctuation}">
        <table class="table table-hover table-striped">
          <thead>
          <tr>
            <th scope="col">Кількість розділових знаків</th>
            <th scope="col">Список розділових знаків</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>${countOfPunctuation}</td>
            <td>${listOfPunctuation}</td>
          </tr>
          </tbody>
        </table>
      </c:if>
    </div>
  </body>
</html>

<%--<script>--%>
<%--  document.addEventListener("DOMContentLoaded", function (){--%>
<%--    document.getElementById("analysisForm").addEventListener("submit", function (e){--%>
<%--      // e.preventDefault();--%>

<%--      const formData = new FormData(this);--%>
<%--      const url = 'analise-text-servlet';--%>
<%--      const context = {--%>
<%--        method: "POST",--%>
<%--        body: formData--%>
<%--      };--%>

<%--      fetch(url, context)--%>
<%--              .then(response => response.text()) // Перетворення відповіді в текст--%>
<%--              .then(data => {--%>
<%--                document.getElementById("analysisResult").innerHTML = data; // Відображення результату в елементі з ID "analysisResult"--%>
<%--              })--%>
<%--              .catch(error => console.error('Error:', error));--%>
<%--    });--%>
<%--  });--%>
<%--</script>--%>
