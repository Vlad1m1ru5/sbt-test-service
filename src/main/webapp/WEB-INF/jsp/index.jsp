<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 11.05.2019
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Приложение клиент-продукт</title>
    </head>
    <body>
        <h2>Мой веб сервис</h2>
        <p>Сейчас <%= new java.util.Date() %></p>
        <table>
            <tr>
                <form action="greeting.jsp">
                    <button type="submit">Получить справку о возможностях</button>
                </form>
            </tr>
        </table>
    </body>
</html>
