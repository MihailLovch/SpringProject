<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page title="Random recipe" jsPath="/assets/javascript/randomRecipeAjax.js">
    <p style="text-align:center;">
        <button id="fetchDataBtn" class="btn btn-warning">Get new recipe</button>
    </p>
    <div style="text-align:center;">
        <img id="recipeImage" src="${imageUrl}" alt="Image" >
    </div>
    <div style="display: flex; justify-content: center;">
        <p id="calories" style="margin-right: 20px;">Calories: ${calorie}</p>
        <p id="fats" style="margin-right: 20px;">Fats: ${fat}</p>
        <p id="carbs" style="margin-right: 20px;">Carbs: ${carb}</p>
    </div>
    <div style="text-align:center;">
        <h3>Description: </h3>
        <div id="info" style="font-size: 16px; font-weight: bold;">${info}</div>
    </div>
    <c:if test="${not empty recipe}">
        <div style="text-align:center;">
            <h3>Recipe: </h3>
            <div id="recipe" style="font-size: 16px; font-weight: bold;">${recipe}</div>
        </div>
    </c:if>
</t:page>

