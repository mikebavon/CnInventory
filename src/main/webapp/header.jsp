<%@ page import="com.cohort.view.HomePage" %>
<%@ page isELIgnored="false" %>
<h2><%= HomePage.homePageMsg() %></h2>
<h1>${initParam["Application Name"]}</h1></br>
Version ${initParam["Application Version"]}</h1></br>
${param.pageName}