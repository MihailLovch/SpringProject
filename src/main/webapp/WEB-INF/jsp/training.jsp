<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<t:page title="Trainings list">
  <c:if test="${not empty error}">
    <div style="color: red; margin-top: 100px"> ${error}</div>
  </c:if>

  <c:forEach var="training" items="${trainings}" varStatus="loop">
    <div class="align-items-center ml-3">
      <span>${training.name}</span>
      <span id="calorie">Calories per minute: ${training.calories}</span>
      <c:if test="${user != null}">
        <form action="/trainings/train"  method="get">
          <input type="hidden" name="trainingId" value="${training.id}">
          <label for="gram${loop.index}">Minutes:</label><input name="minutes" type="number" id="gram${loop.index}" value="1" max="60">
          <input type="submit" value="Train" id="submit${loop.index}">
        </form>
      </c:if>
    </div>
  </c:forEach>
</t:page>

