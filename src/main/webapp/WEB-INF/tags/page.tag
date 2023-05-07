<%@tag description="Page Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="css" required="false" type="java.lang.String"%>
<%@attribute name="jsPath" required="false" type="java.lang.String"%>
<%@attribute name="logInPage" required="false" type="java.lang.Boolean" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="${css}">
        <script src="${jsPath}"></script>
    </head>
<body>
<header class="p-3 bg-secondary text-white fixed-top mb-3">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${s:mvcUrl("MPC#list").build()}" class="nav-link px-2 text-white">Home</a></li>
                <li><a href="" class="nav-link px-2 text-white">Dashboard</a></li>
                <li><a href="${s:mvcUrl("RC#view").build()}" class="nav-link px-2 text-white">Recipes</a></li>
                <li><a href="${s:mvcUrl("RRC#getRandomRecipe").build()}" class="nav-link px-2 text-white">Random recipes</a></li>
                <li><a href="${s:mvcUrl("MPC#view").build()}" class="nav-link px-2 text-white">Profile</a></li>
            </ul>
            <c:if test="${true}">
                <a href="${s:mvcUrl("LC#loginInit").build()}" class="btn btn-warning">Log in</a>
            </c:if>
            <c:if test="${true}">
            <div class="text-end">
                <a href="${s:mvcUrl("SC#view").build()}" class="btn btn-warning ml-1" role="button">Sign-up</a>
            </div>
            </c:if>

        </div>
    </div>
</header>
<div style="margin-top: 80px">
<jsp:doBody/>
</div>
</body>
</html>
