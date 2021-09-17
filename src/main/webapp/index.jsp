<%@ page import="com.cohort.view.HomePage" %>
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
        <h2><%= HomePage.homePageMsg() %></h2>
        <h1><%= application.getInitParameter("Application Name") %></h1></br>
        Version <%= application.getInitParameter("Application Version") %></h1></br>
        &nbsp
        </br></br>
        <h3>Login</h3>
        <hr/>
        <form action="./login" method="POST">

        <%
            String sessionMsg = (String) session.getAttribute("LOGIN_MSG");
            if (sessionMsg != null)
                out.print("ERROR: " + sessionMsg + "<BR/>");
        %>

        <label for="fname">Username:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="lname">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Login">
        </form>
        <% session.invalidate(); %>
</html>
