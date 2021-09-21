<%@ page import="com.cohort.view.HomePage" %>
<h2><%= HomePage.homePageMsg() %></h2>
<h1><%= application.getInitParameter("Application Name") %></h1></br>
Version <%= application.getInitParameter("Application Version") %></h1></br>
<%= request.getParameter("pageName") %>