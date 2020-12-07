<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Application Registration</h1>
<font color="green">${succ }</font>
<font color="red">${fail }</font>
<form:form action="saveCitizen" method="post" modelAttribute="citizen">

<form:hidden path="sno"/>
<table>
<tr><td>First Name</td><td><form:input path="firstName"/></td></tr>
<tr><td>Last Name</td><td><form:input path="lastName"/></td></tr>
<tr><td>DOB</td><td><form:input path="dob" type="date"/></td></tr>
<tr><td>Gender</td><td><form:radiobutton path="gender" value="M"/>Male<form:radiobutton path="gender" value="F" />Female</td></tr>
<tr><td>SSNId</td><td><form:input path="ssnId" /></td></tr>
<tr><td>Phone No</td><td><form:input path="phoneNo" /></td></tr>
<tr><td>Email</td><td><form:input path="email" /></td></tr>
<tr><td><input type="reset"></td><td><form:button>Submit</form:button></td></tr>


</table>

</form:form>

</div>
</body>
</html>