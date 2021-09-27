<%@ page isELIgnored="false" %>
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

        ${sessionScope.LOGIN_MSG}

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
