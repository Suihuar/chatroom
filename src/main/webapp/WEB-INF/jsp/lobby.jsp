<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.entity.Chatroom" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chat Lobby</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        .chatroom-list {
            list-style-type: none;
            padding: 0;
        }
        .chatroom-item {
            background-color: #f9f9f9;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 3px;
        }
        .chatroom-item a {
            text-decoration: none;
            color: #007bff;
        }
        .account-link {
            display: block;
            margin-top: 20px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Chat Lobby</h1>

    <ul class="chatroom-list">
        <%
            List<Chatroom> chatrooms = (List<Chatroom>)request.getAttribute("chatrooms");
            if (chatrooms != null) {
                for (Chatroom chatroom : chatrooms) {
        %>
        <li class="chatroom-item">
            <a href="${pageContext.request.contextPath}/chatroom/<%= chatroom.getId() %>">
                <%= chatroom.getName() %>
            </a>
        </li>
        <%
                }
            }
        %>
    </ul>

    <a href="${pageContext.request.contextPath}/account" class="account-link">My Account</a>
</div>
</body>
</html>
