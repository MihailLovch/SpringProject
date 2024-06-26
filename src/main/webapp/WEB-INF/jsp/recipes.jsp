<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page title="Recipes list" jsPath="/assets/javascript/slider.js">
    <c:if test="${not empty error}">
        <div style="color: red; margin-top: 100px"> ${error}</div>
    </c:if>

    <c:if test="${not empty user}">
        <form action="/recipes/favorite" method="get">
            <input type="submit" value="Show only favorite">
        </form>
    </c:if>

    <c:forEach var="recipe" items="${recipes}" varStatus="loop">
        <div class="align-items-center">
            <span>${recipe.name}</span>
            <span id="calorie${loop.index}">Calories: ${recipe.calories}</span>
            <span id="protein${loop.index}">Proteins: ${recipe.proteins}</span>
            <span id="fat${loop.index}">Fats: ${recipe.fat}</span>
            <span id="carb${loop.index}">Carbs: ${recipe.carbs}</span>
            <c:if test="${user != null}">
                <form action="/recipes/consume" method="get">
                    <input type="hidden" name="recipeId" value="${recipe.id}">
                    <div class="slidecontainer">
                        <input type="range" min="1" max="1000" value="100" class="slider" id="myRange${loop.index}">
                        <span id="grams${loop.index}"> </span>
                    </div>
                    <input name="grams" style="display: none" id="gram${loop.index}" value="100">
                    <input type="submit" value="Eat it" id="submit${loop.index}">
                </form>
                <form action="/recipes/add-to-prefer" method="get">
                    <input type="hidden" name="recipeId" value="${recipe.id}">
                    <input type="submit" value="Add to favorite" id="submit${loop.index}">
                </form>

            </c:if>
        </div>
    </c:forEach>
</t:page>

