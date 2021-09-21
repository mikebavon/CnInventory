<%@ page import="com.cohort.view.HomePage" %>
<jsp:useBean id="login" class="com.cohort.model.Login" />

<%! String usernameInThisPage="something.else@test.com"; %>

<jsp:setProperty name="login" property="password" />
<jsp:setProperty name="login" property="username" value="<%= usernameInThisPage %>" />

Username Given: <jsp:getProperty name="login" property="username"/> <br/>
Password Given: <jsp:getProperty name="login" property="password"/> <br/>
Password Given: <jsp:getProperty name="login" property="userType"/>