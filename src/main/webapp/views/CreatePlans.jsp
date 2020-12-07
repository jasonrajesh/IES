<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Create Plan</h1>

		<form:form action="planSave" mothod="post" modelAttribute="plan">
		<font color="green"> ${succ }</font>
			<table>
				<tr>
				<form:hidden path="pid"/>
					<td>Plan Name</td>
					<td><form:input path="pname" /></td>
				</tr>
				<tr>
					<td>Plan Description</td>
					<td><form:textarea path="pdesc" /></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="sdate" type="date"/></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><form:input path="edate" type="date"/></td>
				</tr>
				
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit"></td>
				</tr>
				<tr><td><a href="/">Home</a></td></tr>
			</table>

		</form:form>


	</div>
</body>
</html>