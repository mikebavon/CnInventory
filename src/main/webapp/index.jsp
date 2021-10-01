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

        <div id="loginForm" class="container"></div>
        <div id="customerForm" class="container"></div>
        <div id="registerUser" class="container"></div>

        <script>
            var appComponents = {
                htmlForm:{
                    formCmp:{},
                    render: function(newFormCmp){
                        this.formCmp = newFormCmp;

                        var formToRender = '<h2>' + this.formCmp.formTitle + '</h2>';

                        formToRender += '<form action="' + this.formCmp.url + '" method="' + this.formCmp.method + '">';

                        this.formCmp.items.forEach(item=>{
                            formToRender += '<label for="' + item.id +'">' + item.label + ':</label><br>'
                             +'<input type="' + item.type + '" id="' + item.id +'" name="' + item.name + '"><br>';
                        });

                        formToRender += '<input type="' + this.formCmp.submitBtn.type + '" value="' + this.formCmp.submitBtn.value + '"></form>';

                        console.log(formToRender);
                        document.getElementById(this.formCmp.renderId).innerHTML = formToRender;

                    }
                }
            };

            // login form
            appComponents.htmlForm.render({
                 url: "./login",
                 method: "POST",
                 formTitle: 'Login',
                 renderId: "loginForm",
                 items: [{
                    label: "Username",
                    name: "username",
                    id: "username",
                    type: "text"
                },{
                    label: "Password",
                    name: "password",
                    id: "password",
                    type: "password"
                },{
                    label: "User Type",
                    name: "userTypeStr",
                    id: "userTypeStr",
                    type: "text"
                }],
                submitBtn: {
                    type: 'submit',
                    value: 'Login'
                }
            });

            //customer form
            appComponents.htmlForm.render({
                 url: "./saveCustomer",
                 method: "POST",
                 formTitle: 'Create Customer',
                 renderId: "customerForm",
                 items: [{
                    label: "Customer Name",
                    name: "customer",
                    id: "customer",
                    type: "text"
                },{
                    label: "Customer Address",
                    name: "address",
                    id: "customer_address",
                    type: "text"
                }],
                submitBtn: {
                    type: 'submit',
                    value: 'Save Customer'
                }
            });

            //register user
            appComponents.htmlForm.render({
                 url: "./register",
                 method: "POST",
                 formTitle: 'Register User',
                 renderId: "registerUser",
                 items: [{
                    label: "Full Names",
                    name: "fullName",
                    id: "fullName",
                    type: "text"
                },{
                    label: "Email",
                    name: "email",
                    id: "email",
                    type: "text"
                }],
                submitBtn: {
                    type: 'submit',
                    value: 'Register'
                }
            });

        </script>

        <% session.invalidate(); %>
        </body>
</html>


