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

        * {
          box-sizing: border-box;
        }

        input[type=text], select, textarea {
          width: 100%;
          padding: 12px;
          border: 1px solid #ccc;
          border-radius: 4px;
          resize: vertical;
        }

        label {
          padding: 12px 12px 12px 0;
          display: inline-block;
        }

        input[type=submit] {
          background-color: #4CAF50;
          color: white;
          padding: 12px 20px;
          border: none;
          border-radius: 4px;
          cursor: pointer;
          float: right;
        }

        input[type=submit]:hover {
          background-color: #45a049;
        }

        .container {
          border-radius: 5px;
          background-color: #f2f2f2;
          padding: 20px;
        }

        .col-25 {
          float: left;
          width: 25%;
          margin-top: 6px;
        }

        .col-75 {
          float: left;
          width: 75%;
          margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
          content: "";
          display: table;
          clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
          .col-25, .col-75, input[type=submit] {
            width: 100%;
            margin-top: 0;
          }
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
        <victor:if test="${tfn:containsIgnoreCase(sessionScope.LOGIN_MSG, 'ERROR') }" var="errorFound">
            ERROR TO BE PRINTED<br/>
        </victor:if>
        ${errorFound}<br/>

        ${sessionScope.LOGIN_MSG}<br/>

        <div id="componentRender" class="container"></div>

        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <button onclick="appComponents.htmlTable()">Click me</button>
        <div id="showItems"></div>

        <script src="js/app.js"></script>
        <script src="js/login.js"></script>
        <script src="js/items.js"></script>
        <% session.invalidate(); %>
        </body>
</html>


