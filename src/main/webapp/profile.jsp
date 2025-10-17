<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  HttpSession ses = request.getSession(false);
  String username = (String) ses.getAttribute("username");
  String password = (String) ses.getAttribute("password");
  if (username == null) {
    response.sendRedirect("login");
    return;
  }
%>
<html>
<head>
    <title>Профиль пользователя</title>
</head>
<body>
  <h1>Профиль пользователя</h1>
    <div>
      <p>Ваша информация:</p>
      <ul>
        <li>Логин: ${username}</li>
        <li>Пароль: ${password}</li>
      </ul>
    </div>
  <form action="logout" method="post">
    <input type="submit" value="Выйти">
  </form>
</body>
</html>
