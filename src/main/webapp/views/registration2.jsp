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

		$("#userEmail").blur(function() {
			$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "uniqueMailCheck?email="+$("#userEmail").val(),
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
		<h1>Registration Form</h1>
		<form:form action="/registeruser" method="POST"
			modelAttribute="worker">
			<p align="center" style="color: green;">${successmsg }</p>
			<p align="center" style="color: green;">${errmsg }</p>
			<table>
				<tbody>

					<tr>
						<td>FirstName:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>LastName:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="userEmail" id="userEmail" /><font color='red'><span id="errMsg"></span></font></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><form:input path="userMobile" /></td>
					</tr>
					<tr>
						<td>DOB:</td>
						<td><form:input path="dob" /></td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td><form:radiobutton path="gender" value="M" /> Male <form:radiobutton
								path="gender" value="F" /> Female</td>
					</tr>
					<tr>
						<td>Select Country:</td>
						<td><form:select path="countryId" id="countryId">
								<form:option value="">--Select--</form:option>
								<form:options items="${countries}" />
							</form:select></td>
					</tr>
					<tr>
						<td>Select State:</td>
						<td><form:select path="stateId" id="stateId">
								<form:option value="">--Select--</form:option>								
							</form:select></td>

					</tr>
					<tr>
						<td>Select City:</td>
						<td><form:select path="cityId" id="cityId">
								<form:option value="">--Select--</form:option>
							</form:select></td>

					</tr>

					<tr>
						<td><input type="reset" value="Reset"></td>
						<td><input type="submit" value="Submit" id="submitBtn"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>

</body>
</html>