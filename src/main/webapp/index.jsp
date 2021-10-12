<%@ page isELIgnored="false" %>
<%@ taglib prefix="victor" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./css/app.css"></link>
    </head>
    <body>
        </br></br>
        <h3>Login</h3>
        <hr/>

        <div id="showErrorMsg"></div>
        <div id="componentRender" class="container"></div>

        <script src="js/cohort9.lib.js"></script>
        <script src="js/login.js"></script>
        <% session.invalidate(); %>
        </body>
</html>


