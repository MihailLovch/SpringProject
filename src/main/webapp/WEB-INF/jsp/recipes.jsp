<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page css="${pageContext.request.contextPath}/css/formPopOut.css" title="Recipes list"
        jsPath="${pageContext.request.contextPath}/javascript/recipeSlider.js">
    <c:if test="${not empty error}">
        <div style="color: red; margin-top: 100px"> ${error}</div>
    </c:if>

    <c:if test="${not empty user}">
        <form action="/favorite" method="get">
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
                <form action="/consume" method="get">
                    <input type="hidden" name="recipeId" value="${recipe.id}">
                    <div class="slidecontainer">
                        <input type="range" min="1" max="1000" value="100" class="slider" id="myRange${loop.index}">
                        <span id="grams${loop.index}"> </span>
                    </div>
                    <input name="grams" style="display: none" id="gram${loop.index}" value="100">
                    <input type="submit" value="Eat it" id="submit${loop.index}">
                </form>
                <form action="/add-to-prefer" method="get">
                    <input type="hidden" name="recipeId" value="${recipe.id}">
                    <input type="submit" value="Add to favorite" id="submit${loop.index}">
                </form>

            </c:if>
        </div>
    </c:forEach>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let maxId = -1;
            let i = 0;
            let calData = [];
            let proteinData = [];
            let carbData = [];
            let fatData = [];
            while (true) {

                if (document.getElementById("myRange" + i) == null) {
                    break;
                } else {
                    calData.push(parseInt(document.getElementById("calorie" + i).innerHTML.split(" ")[1]));
                    proteinData.push(parseInt(document.getElementById("protein" + i).innerHTML.split(" ")[1]));
                    carbData.push(parseInt(document.getElementById("carb" + i).innerHTML.split(" ")[1]));
                    fatData.push(parseInt(document.getElementById("fat" + i).innerHTML.split(" ")[1]));
                    maxId = i;
                    i++;
                }
            }
            for (let i = 0; i <= maxId; i++) {
                let slider = document.getElementById("myRange" + i);
                let output = document.getElementById("grams" + i);
                let gram = document.getElementById("gram" + i);
                let calorie = document.getElementById("calorie" + i);
                let protein = document.getElementById("protein" + i);
                let carb = document.getElementById("carb" + i);
                let fat = document.getElementById("fat" + i);

                output.innerHTML = slider.value;

                slider.oninput = function () {
                    output.innerHTML = this.value;
                    calorie.innerText = "Calories: " + (calData[i] * slider.value / 100).toString();
                    protein.innerText = "Proteins: " + (proteinData[i] * slider.value / 100).toString();
                    carb.innerText = "Carbs: " + (carbData[i] * slider.value / 100).toString();
                    fat.innerText = "Fats: " + (fatData[i] * slider.value / 100).toString();
                    gram.value = this.value;
                }
            }
        });
    </script>
</t:page>

