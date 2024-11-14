<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Login</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        input[type=radio] {
            display: inline-block;
            margin-left: 45px;
        }
        input[type=checkbox] {
            display: inline-block;
            margin-right: 190px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
        .error {
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>
    <div align="center">
        <h2>User Login</h2>
        <form:form action="login" method="post" modelAttribute="userLogin">

            <form:label path="email">E-mail:</form:label>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error" /><br/>

            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error" /><br/>

            <form:button>Login</form:button>
        </form:form>

        <% if (request.getAttribute("loginError") != null) { %>
        <div class="error">${loginError}</div>
        <% } %>

        <form action="register" method="get">
            <button type="submit">Register</button>
        </form>
</div>
</body>
</html>