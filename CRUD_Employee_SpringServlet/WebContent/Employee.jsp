<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="e"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>
<form action="EmployeeServlet">
<table>
	<tr>
		<td><label>Enter the Employee No:</label></td>
		<td><input type="text" name="empno"/></td>
	</tr>
	<tr>
		<td><label>Enter the Department Id:</label></td>
		<td><input type="text" name="deptid" value="${k1}"/></td>
	</tr>
	<tr>
		<td><label>Enter the Salary:</label></td>
		<td><input type="text" name="salary" value="${k2}"/></td>
	</tr>
</table>
<hr>
<input type="submit" name ="insert" value="Add"/>
<input type="submit" name ="update" value="Update"/>
<input type="submit" name ="select" value="Select"/>
<input type="submit" name ="multiselect" value="MultiSelect"/>
<input type="submit" name ="delete" value="Delete"/>
</form>

<h1><e:out value="${msg}"/></h1>
<h3><e:forEach var="i" items="${val}">
<e:out value="${i}" />
</e:forEach></h3>

</body>
</html>