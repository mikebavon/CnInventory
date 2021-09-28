<%@ page isELIgnored="false" %>
<%@ taglib prefix="victor" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tfn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tsql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="txml" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
    <head>
        <style>
        table, th, td {
            border: 1px solid black;
            width: 100%;
            border-collapse: collapse;
            background-color: #96D4D4;
        }
        </style>
    </head>
    <body>
        <jsp:include page="general_header.jsp">
            <jsp:param name="pageName" value="SIGN IN" />
        </jsp:include>

        &nbsp
        </br></br>
        <h3>Login</h3>
        <hr/>
        <form action="./login" method="POST">

        <victor:if test="${tfn:containsIgnoreCase(sessionScope.LOGIN_MSG, 'ERROR') }" var="errorFound">
            ERROR TO BE PRINTED<br/>
        </victor:if>
        ${errorFound}<br/>

        <victor:set var="marks" value="${2*40}" />

        <victor:choose>
            <victor:when test="${ marks gt 50 and marks lt 80}">
                PASSED<BR>
            </victor:when>
            <victor:when test="${ marks lt 50}">
                FAILED<BR>
            </victor:when>
            <victor:otherwise>
                EXCELLENT<BR>
            </victor:otherwise>
        </victor:choose>

        ${sessionScope.LOGIN_MSG}<br/>

        <label for="fname">Username:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <label for="userTypeStr">User Type:</label><br>
        <input type="text" id="userTypeStr" name="userTypeStr"><br><br>

        <input type="submit" value="Login">
        </form>
        <% session.invalidate(); %>
</html>
