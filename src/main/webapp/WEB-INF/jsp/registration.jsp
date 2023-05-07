<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<t:page title="Registration" css="${pageContext.request.contextPath}/css/formPopOut.css" >--%>
<t:page title="Registration">
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            margin: 0 auto;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        table td, table th {
            padding: 10px;
        }

        table th {
            text-align: left;
            background-color: #336699;
            color: #fff;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type=submit] {
            display: block;
            margin: 20px auto;
            padding: 10px;
            background-color: #336699;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #26547c;
        }
    </style>

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

<%--    <div class="form-container">--%>
<%--        <form:form method="POST" modelAttribute="signupForm">--%>
<%--            <label for="nickName">Nick Name:</label>--%>
<%--            <form:input type="text" id="nickName" path="nickName" />--%>
<%--            <label for="password">Password:</label>--%>
<%--            <form:password id="password" path="password" />--%>
<%--            <label for="email">Email:</label>--%>
<%--            <form:input type="email" id="email" path="email" />--%>
<%--            <label for="weight">Weight (kg):</label>--%>
<%--            <form:input type="number" id="weight" path="weight" />--%>
<%--            <label for="height">Height (cm):</label>--%>
<%--            <form:input type="number" id="height" path="height" />--%>
<%--            <label for="age">Age:</label>--%>
<%--            <form:input type="number" id="age" path="age" />--%>
<%--            <label for="sex">Sex:</label>--%>
<%--            <form:radiobuttons id="sex" path="sex" items="${sexOptions}" />--%>
<%--            <button type="submit">Register</button>--%>
<%--        </form:form>--%>
<%--    </div>--%>
</t:page>