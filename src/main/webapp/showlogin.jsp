<%@ page import="com.cohort.view.HomePage" %>
<%@ page isELIgnored="false" %>

<jsp:useBean id="login" class="com.cohort.model.Login" />

<%!
    String usernameInThisPage ="something.else@test.com";
%>

<jsp:setProperty name="login" property="password" />
<jsp:setProperty name="login" property="username" value="${usernameInThisPage}" />
<jsp:setProperty name="login" property="userTypeStr" />

Username Given: ${login.username} <br/>
Password Given: ${login.password} <br/>
User Type Given: ${login.userTypeStr}

Username Given: ${param.username} <br/>
Password Given: ${param.password} <br/>
User Type Given: ${param.userTypeStr}