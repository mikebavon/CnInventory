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
<jsp:include page="header.jsp">
    <jsp:param name="pageName" value="SIGN IN" />
</jsp:include>

USER: ${sessionScope.USER_NAME}</br>
USER: ${sessionScope.email}</br>
&nbsp
</br>
</br>
${initParam["Page Name"]}<br/>

<h3>Item List</h3><br/>
<a href="../item">Add Item</a><br/>
<table>
<th>Item</th>
<th>Purchase Price</th>
<th>Selling Price</th>
    ${sessionScope.items}
</table>
</body>
</html>