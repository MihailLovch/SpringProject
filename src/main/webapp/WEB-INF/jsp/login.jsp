<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page title="Login">
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }
        form {
            background-color: #fff;
            border: 1px solid #ccc;
            margin: 0 auto;
            padding: 20px;
            width: 400px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="password"] {
            border: 1px solid #ccc;
            border-radius: 3px;
            display: block;
            font-size: 16px;
            margin-bottom: 20px;
            padding: 10px;
            width: 100%;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            border: none;
            border-radius: 3px;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            padding: 10px;
            width: 100%;
        }
    </style>
    <h1>Login Form</h1>
    <c:if test="${not empty errorMessage}">
        <p>${errorMessage}</p>
    </c:if>
    <form:form method="POST" modelAttribute="userForm">
        <form:label path="email">Email:</form:label>
        <form:input type="email" path="email" /> <br>
        <form:errors path="email"/>

        <form:label path="password">Password:</form:label>
        <form:input type="password" path="password" />
        <form:errors path="password"/>

        <input type="submit" value="Login" />
    </form:form>
</t:page>

