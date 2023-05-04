<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page title="Random recipe">
    <p style="text-align:center;">
        <a href="${s:mvcUrl("RRC#getRandomRecipe").build()}" class="btn btn-warning">Get new recipe</a>
    </p>
    <div style="text-align:center;">
        <img src="${imageUrl}" alt="Image" >
    </div>
    <div style="display: flex; justify-content: center;">
        <p style="margin-right: 20px;">Calories: ${calorie}</p>
        <p style="margin-right: 20px;">Fats: ${fat}</p>
        <p style="margin-right: 20px;">Carbs: ${carb}</p>
    </div>
    <div style="text-align:center;">
        <h3>Description: </h3>
        <div style="font-size: 16px; font-weight: bold;">${info}</div>
    </div>
    <c:if test="${not empty recipe}">
        <div style="text-align:center;">
            <h3>Recipe: </h3>
            <div style="font-size: 16px; font-weight: bold;">${recipe}</div>
        </div>
    </c:if>
</t:page>

