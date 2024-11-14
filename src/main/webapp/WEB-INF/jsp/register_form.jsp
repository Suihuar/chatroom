<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration Form</title>
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
        <h2>User Registration</h2>
        <form:form action="register" method="post" modelAttribute="user">
            <form:label path="name">Full name:</form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error" /><br/>

            <form:label path="email">E-mail:</form:label>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error" /><br/>

            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
            <form:errors path="password" cssClass="error" /><br/>

            <form:label path="birthday">Birthday (yyyy-mm-dd):</form:label>
            <form:input path="birthday" type="date" />
<%--            <input type="date" th:field="*{birthday}" />--%>
            <form:errors path="birthday" cssClass="error" /><br/>

            <form:label path="gender">Gender:</form:label>
            <form:radiobutton path="gender" value="Male"/>Male
            <form:radiobutton path="gender" value="Female"/>Female<br/>

            <form:label path="profession">Profession:</form:label>
            <form:select path="profession" items="${professionList}" /><br/>

            <form:label path="married">Married?</form:label>
            <form:checkbox path="married"/><br/>

            <form:label path="note">Note:</form:label>
            <form:textarea path="note" cols="25" rows="5"/><br/>

            <form:button>Register</form:button>
        </form:form>
</div>
</body>
</html>