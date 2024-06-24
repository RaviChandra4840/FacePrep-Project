<%@ page import="yourpackage.UserDAO, yourpackage.User" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    if (username != null && password != null && email != null) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("customer");

        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user);
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="register.jsp" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        Email: <input type="email" name="email"><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>