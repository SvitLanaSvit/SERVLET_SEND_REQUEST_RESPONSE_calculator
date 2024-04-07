<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Svitlana
  Date: 07.04.2024
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<%--    <link href="/assects/css/slimselect.css" rel="stylesheet">--%>
<%--    <script src="/assects/js/slimselect.min.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <form id="analysisForm" method="post" action="calculate">

            <div class="mb-3 w-25">
                <label for="num1" class="form-label">Number_1</label>
                <input type="number" class="form-control" id="num1" name="num1" required>
            </div>
            <div class="mb-3 w-25">
                <label for="num2" class="form-label">Number_2</label>
                <input type="number" class="form-control" id="num2" name="num2" required>
            </div>

            <div class="mb-3 w-25">
                <select class="form-select" aria-label="Default select example" name="operation" id="operation" required>
                    <option value="" selected>Open this select menu</option>
                    <option value="add">Додавання</option>
                    <option value="subtract">Віднімання</option>
                    <option value="multiply">Множення</option>
                    <option value="divide">Ділення</option>
                </select>
            </div>

            <div class="btn-group">
                <button type="submit" name="submit" class="btn btn-primary">Розрахувати</button>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Повернутися</a>
            </div>
        </form>
        <c:if test="${not empty result}">
            <c:choose>
                <c:when test="${operation ne 'divide'}">
                    <div id="success" class="alert alert-success">
                        <c:choose>
                            <c:when test="${operation eq 'add'}">
                                <h3>${num1} + ${num2} = ${result}</h3>
                            </c:when>
                            <c:when test="${operation eq 'subtract'}">
                                <h3>${num1} - ${num2} = ${result}</h3>
                            </c:when>
                            <c:when test="${operation eq 'multiply'}">
                                <h3>${num1} * ${num2} = ${result}</h3>
                            </c:when>
                        </c:choose>
                    </div>
                </c:when>
                <c:when test="${operation eq 'divide'}">
                    <c:choose>
                        <c:when test="${num2 ne 0}">
                            <div id="success" class="alert alert-success">
                                <h3>${num1} / ${num2} = ${result}</h3>
                            </div>
                        </c:when>
                        <c:when test="${num2 eq 0}">
                            <div id="warning" class="alert alert-warning">
                                <h3>${num1} / ${num2} ! ${result}</h3>
                            </div>
                        </c:when>
                    </c:choose>
                </c:when>
            </c:choose>
        </c:if>
    </div>
    <script>
        // new SlimSelect({
        //     select: '#operation'
        // })
        $(document).click(() => {
            $('#success').css('display', 'none');
            $('#warning').css('display', 'none');
        });
    </script>
</body>
</html>