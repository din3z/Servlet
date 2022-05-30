<%--
  Created by IntelliJ IDEA.
  User: khsid
  Date: 26.05.2022
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>

<%@page import ="ru.appline.logic.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Домашняя страница по работе с пользователями</h1>
  Введите ID пользователя (0 - для вывода всего списка)
  <br/>
  Доступно:
  <%
    Model model = Model.getInstance();
  out.print(model.getFrontList().size());
  %>
  <form method="get" action="get">
    <label>ID
    <input type="text" name="id"><br/>
    </label>
    <button type="submit">Поиск</button>
  </form>
  <a href="addUser.html">Cоздать нового пользователя</a><br/>
  <a href="deleteUser.html">Удалить пользователя</a><br/>
  <a href="putUser.html">Редактировать данные пользователя</a><br/>
  <a href="calc.html">открыть калькулятор</a><br/>
  </body>
</html>
