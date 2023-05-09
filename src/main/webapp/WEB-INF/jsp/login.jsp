<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page title="Login" css ="/assets/css/login.css" >
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

