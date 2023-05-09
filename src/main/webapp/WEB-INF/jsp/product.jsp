<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page title="Recipes list" jsPath="/assets/javascript/slider.js">
    <c:if test="${not empty error}">
        <div style="color: red; margin-top: 100px"> ${error}</div>
    </c:if>

    <c:forEach var="product" items="${products}" varStatus="loop">
        <div class="align-items-center">
            <span>${product.name}</span>
            <span id="calorie${loop.index}">Calories: ${product.calories}</span>
            <span id="protein${loop.index}">Proteins: ${product.proteins}</span>
            <span id="fat${loop.index}">Fats: ${product.fat}</span>
            <span id="carb${loop.index}">Carbs: ${product.carbs}</span>
            <c:if test="${user != null}">
                <form action="/products/consume" method="get">
                    <input type="hidden" name="productId" value="${product.id}">
                    <div class="slidecontainer">
                        <input type="range" min="1" max="1000" value="100" class="slider" id="myRange${loop.index}">
                        <span id="grams${loop.index}"> </span>
                    </div>
                    <input name="grams" style="display: none" id="gram${loop.index}" value="100">
                    <input type="submit" value="Eat it" id="submit${loop.index}">
                </form>
            </c:if>
        </div>
    </c:forEach>
</t:page>

