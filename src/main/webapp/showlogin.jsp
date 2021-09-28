<%@ taglib prefix="nancy" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cohort.view.HomePage" %>
<%@ page isELIgnored="false" %>

<jsp:useBean id="login" class="com.cohort.model.Login" />

<jsp:setProperty name="login" property="password" />
<nancy:set var="username" value="Welcome message" scope="request" target="login" property="username" />
<jsp:setProperty name="login" property="userTypeStr" />

${username}<br/>
${login}<br/><br/><br/>
Username Given: ${login.username} <br/>
Password Given: ${login.password} <br/>
User Type Given: ${login.userTypeStr}