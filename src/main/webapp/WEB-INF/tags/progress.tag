<%@tag description="Page Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="category" required="true" type="java.lang.String" %>
<%@attribute name="max" required="true" type="java.lang.Double" %>
<%@attribute name="consumed" required="true" type="java.lang.Double" %>

<jsp:doBody/>
<div title="${title}">
    <div>
        <span>${category}</span>

        <span><fmt:formatNumber value="${consumed/max * 100}" pattern="#0.00"/>%</span>
    </div>
    <div>
        <progress id="fats-progress" max="${max}" value="${consumed}"></progress>
    </div>
    <div>
        <span> <fmt:formatNumber value="${consumed}" pattern="#0.00"/>g </span>
        <c:if test="${max < consumed}">
            <span style="margin-left: 15px"> <fmt:formatNumber value="${consumed - max}" pattern="#0.00"/>g over </span>
        </c:if>
        <c:if test="${max > consumed}">
            <span style="margin-left: 15px"><fmt:formatNumber value="${max - consumed}" pattern="#0.00"/>g left</span>
        </c:if>
    </div>
</div>
<jsp:doBody/>