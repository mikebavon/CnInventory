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
        <% if(session.getAttribute("userType") == "ADMIN"){ %>
            what is happening.....
            <jsp:include page="header.jsp">
                <jsp:param name="pageName" value="SIGN IN" />
            </jsp:include>

        <% } else { %>

            <jsp:include page="general_header.jsp">
                <jsp:param name="pageName" value="SIGN IN" />
            </jsp:include>

        <% } %>

        &nbsp
        </br></br>
        <h3>Login</h3>
        <hr/>
        <form action="./showlogin.jsp" method="POST">

        <%
            String sessionMsg = (String) session.getAttribute("LOGIN_MSG");
            if (sessionMsg != null)
                out.print("ERROR: " + sessionMsg + "<BR/>");
        %>

        <label for="fname">Username:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <label for="userType">Password:</label><br>
        <input type="text" id="userType" name="userType"><br><br>

        <input type="submit" value="Login">
        </form>
        <% session.invalidate(); %>
</html>
