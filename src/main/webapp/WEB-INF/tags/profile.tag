<%@tag description="Page Tag" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@attribute name="edit" required="true" type="java.lang.Boolean" %>

    <form:form method="post" modelAttribute="editedUserForm">
        <section class="section about-section gray-bg" id="about">
            <div class="container">
                <div class="row align-items-center flex-row-reverse">
                    <div class="col-lg-6">
                        <div class="about-text go-to">
                            <h3 class="dark-color">About You</h3>
                            <h6 class="theme-color lead">Here presented your personal information, that you mentioned
                                while
                                registration</h6>
                            <c:if test="${edit}">
                                <p>Here you can see and change your parameters by editing them and clicking submit
                                    button.</p>
                            </c:if>
                            <div class="row about-list">
                                <div class="col-md-6">
                                    <div class="media">
                                        <label>Nickname</label>
                                        <c:if test="${not edit}">
                                            <p>${user.getName()}</p>
                                        </c:if>
                                        <c:if test="${edit}">
                                            <input type="text" class="margin-left-4" value="${user.getName()}"
                                                   name="name"
                                                   required>
                                        </c:if>
                                    </div>
                                    <div class="media">
                                        <label>Email</label>
                                        <p>${user.getEmail()}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="about-avatar">
                            <img src="<c:url value="/assets/static/userAvatar.png"/>" type="png" title="" alt="">
                        </div>
                    </div>
                </div>
                    <div class="counter">
                        <div class="row">
                            <div class="col-6 col-lg-3">
                                <div class="count-data text-center">
                                    <c:if test="${not edit}">
                                        <h6 class="count h2">${user.getWeight()}</h6>
                                    </c:if>
                                    <c:if test="${edit}">
                                        <input type="number" class="count h2" name="weight" value="${user.getWeight()}"
                                               required>
                                    </c:if>
                                    <p class="m-0px font-w-600">Weight</p>
                                </div>
                            </div>
                            <div class="col-6 col-lg-3">
                                <div class="count-data text-center">
                                    <c:if test="${not edit}">
                                        <h6 class="count h2">${user.getHeight()}</h6>
                                    </c:if>
                                    <c:if test="${edit}">
                                        <input type="number" class="count h2" name="height" value="${user.getHeight()}"
                                               required>
                                    </c:if>
                                    <p class="m-0px font-w-600">Height</p>
                                </div>
                            </div>
                            <div class="col-6 col-lg-3">
                                <div class="count-data text-center">
                                    <c:if test="${not edit}">
                                        <h6 class="count h2">${user.age}</h6>
                                    </c:if>
                                    <c:if test="${edit}">
                                        <input type="number" class="count h2" name="age" value="${user.age}"
                                               required>
                                    </c:if>
                                    <p class="m-0px font-w-600">Age</p>
                                </div>
                            </div>
                            <div class="col-6 col-lg-3">
                                <div class="count-data text-center">
                                    <h6 class="count h2" data-to="190" data-speed="190">
                                        <c:if test="${not edit}">
                                        <c:choose>
                                            <c:when test="${user.getSex()}">Male</c:when>
                                            <c:when test="${not user.getSex()}">Female</c:when>
                                        </c:choose></h6>
                                    </c:if>
                                    <c:if test="${edit}">
                                        <select class="count h2" name="sex">
                                            <option
                                                    <c:if test="${user.getSex()}">selected</c:if> value="true">Male
                                            </option>
                                            <option
                                                    <c:if test="${not user.getSex()}">selected</c:if> value="false">
                                                Female
                                            </option>
                                        </select>
                                    </c:if>
                                    <p class="m-0px font-w-600">Sex</p>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </section>
        <c:if test="${not edit}">
            <a href="${s:mvcUrl("LC#logout").build()}" class="btn btn-outline-dark me-2">Sign Out</a>
            <a href="${s:mvcUrl("PEC#view").build()}" class="btn btn-outline-dark me-2">Edit Profile</a>
            <form action="/profile" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" value="Delete Account" class="btn btn-outline-dark me-2">
            </form>
        </c:if>
        <c:if test="${edit}">
            <c:if test="${not empty notice}">
                <div style="color: red">
                    <p>${notice}</p>
                </div>
            </c:if>
            <c:forEach var="errors" items="${errors}">
                <div style="color: red">${errors}</div>
            </c:forEach>
            <input type="submit" value="Submit changes"/>
        </c:if>
    </form:form>
