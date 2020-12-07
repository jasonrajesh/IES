<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(document).ready(function() {

		$("#email").blur(function() {
			$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "uniqueMailCheck?email="+$("#email").val(),
				success : function(data) {
					if(data=="DUPLICATE"){
						$("#errMsg").text("Duplicate Email");
						$("#submitBtn").prop("disabled", true);
					}else{
						$("#submitBtn").prop("disabled", false);
					}
				}
			});

		});			
	
});
	
</script>

</head>
<body>
	<div align="center">
		<h1>Registration</h1>
		<form:form action="saveWorker" method="post" modelAttribute="worker">
		<p align="center" style="color: green;">${SvSucc }</p>
			<p align="center" style="color: red;">${SvFail }</p>
			<table>
				<tr>
					<form:hidden path="sno" />
					<td>First Name</td>
					<td><form:input path="firstName" /></td>

				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>

				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" id="email"/><font color='red'><span id="errMsg"></span></font></td>

				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /></td>

				</tr>
				<tr>
					<td>Date of Birth</td>					
					<td><form:input path="dob" type="date"/></td>

				</tr>
				<tr>
					<td>SSN ID</td>
					<td><form:input path="ssnId" /></td>

				</tr>
				<tr>
					<td>Phone No</td>
					<td><form:input path="phoneNo" /></td>

				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" value="M" /> Male <form:radiobutton
							path="gender" value="F" /> Female</td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:select path="role" id="role">
							<form:option value="">--Select--</form:option>
							<form:option value="caseworker">Case Worker</form:option>
							<form:option value="admin">Admin</form:option>
						</form:select></td>

				</tr>
				<tr>
						<td><input type="reset" value="Reset"></td>
						<td><input type="submit" value="Submit" id="submitBtn"></td>
					</tr>

			<tr><td><a href="/">Home</a></td></tr>
			</table>



		</form:form>




	</div>

</body>
</html>