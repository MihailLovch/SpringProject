<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:page title="Registration" css="/assets/css/registration.css">

    <h1>Registration Form</h1>
    <c:if test="${not empty errorMessage}">
        <p>${errorMessage}</p>
    </c:if>
    <form:form method="post" modelAttribute="signupForm">
        <table>
            <tr>
                <td><form:label path="nickName">Nick Name:</form:label></td>
                <td><form:input path="nickName"/></td>
                <td><form:errors path="nickName"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password:</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td><form:label path="email">Email:</form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td><form:label path="weight">Weight:</form:label></td>
                <td><form:input path="weight"/></td>
                <td><form:errors path="weight"/></td>
            </tr>
            <tr>
                <td><form:label path="height">Height:</form:label></td>
                <td><form:input path="height"/></td>
                <td><form:errors path="height"/></td>
            </tr>
            <tr>
                <td><form:label path="age">Age:</form:label></td>
                <td><form:input path="age"/></td>
                <td><form:errors path="age"/></td>
            </tr>
            <tr>
                <td><form:label path="sex">Sex:</form:label></td>
                <td><form:radiobutton path="sex" value="true" label="Male"/>
                    <form:radiobutton path="sex" value="false" label="Female"/></td>
                <td><form:errors path="sex"/></td>

            </tr>
        </table>
        <input type="submit" value="Register"/>
    </form:form>
</t:page>