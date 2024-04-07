<%--
  Created by IntelliJ IDEA.
  User: Svitlana
  Date: 06.04.2024
  Time: 12:32
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
        <form method="post" action="max-number-servlet">
            <div class="mb-3 w-25">
                <label for="num1" class="form-label">Number_1</label>
                <input type="number" class="form-control" id="num1" name="num1">
            </div>
            <div class="mb-3 w-25">
                <label for="num2" class="form-label">Number_2</label>
                <input type="number" class="form-control" id="num2" name="num2">
            </div>
            <div class="mb-3 w-25">
                <label for="num3" class="form-label">Number_3</label>
                <input type="number" class="form-control" id="num3" name="num3">
            </div>

            <div class="mb-3 w-25" style="display: flex; justify-content: space-between">
                <div class="form-check">
                <input class="form-check-input" type="radio" name="radioButton" id="radioButtonMax" value="max" checked>
                <label class="form-check-label" for="radioButtonMax">
                    Max
                </label>
            </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="radioButton" id="radioButtonMin" value="min">
                    <label class="form-check-label" for="radioButtonMin">
                        Min
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="radioButton" id="radioButtonAverage" value="average">
                    <label class="form-check-label" for="radioButtonAverage">
                        Average
                    </label>
                </div>
            </div>

            <div class="btn-group">
                <button type="submit" name="submit" class="btn btn-primary">Визначити</button>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Повернутися</a>
            </div>
        </form>
    </div>
</body>
</html>
