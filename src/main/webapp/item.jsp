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
    <victor:forEach items="${sessionScope.items}" var="bidhaa">
        <tr>
            <td>${bidhaa.name}</td>
            <td><fmt:formatNumber pattern="##,###.##" type="number" value="${bidhaa.purchasePrice}" /></td>
            <td><fmt:formatNumber pattern="##,###.##" type="number" value="${bidhaa.salePrice}" /></td>
        </tr>
    </victor:forEach>
</table>
<hr/>

<tsql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/inventory" user="root" password="Okello3477#*" var="jstlDb" />
<table>
<th>Item</th>
<th>Purchase Price</th>
<th>Selling Price</th>
    <tsql:update dataSource="${jstlDb}" var="itemsList">
        insert into items(name,purchase_price,sale_price) values (?,?,?);
        <tsql:param>dddddddddddddddddd</tsql:param>
        <tsql:param>111</tsql:param>
        <tsql:param>112</tsql:param>
    </tsql:update>
    <tsql:query dataSource="${jstlDb}" var="itemsList">
        SELECT * FROM items;
    </tsql:query>

    <victor:forEach items="${itemsList.rows}" var="bidhaa">
        <tr>
            <td>${bidhaa.name}</td>
            <td><fmt:formatNumber pattern="##,###.##" type="number" value="${bidhaa.purchase_price}" /></td>
            <td><fmt:formatNumber pattern="##,###.##" type="number" value="${bidhaa.sale_price}" /></td>
        </tr>
    </victor:forEach>
</table>

</body>
</html>