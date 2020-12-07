<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function deleteConfirm(){
	return confirm("Are you sure, you want to change contact status?");
}
</script>

</head>
<body>
<div align="center">

		<table border="1">
			<thead>

				<tr>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>

				</tr>
			</thead>
			<c:forEach items="${worker }" var="worker">
				<tr>
					<td><c:out value="${worker.sno}" /></td>
					<td><c:out value="${worker.firstName}" /></td>
					 <td><c:out value="${worker.lastName}" /></td>
					<td><c:out value="${worker.email}" /></td>
					<td><c:out value="${worker.role}" /></td>
					<td><a href="/editcontact?id=${worker.sno}">edit</a> 
					<a href="/delcontact?id=${worker.sno}" onclick="return deleteConfirm()">delete</a></td>
				</tr>
			</c:forEach>
		
		</table>
		<a href="/">Home</a>
		
	</div>
</body>
</html>