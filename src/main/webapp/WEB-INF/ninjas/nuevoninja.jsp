<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninja">
			<div class="form-group">
				<form:select class="form-control" path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id} "> ${dojo.name}  
						</form:option>
					</c:forEach>
				</form:select>
				<div class="form-group">
					<form:errors class="text-danger" path="firstName" /><br>
					<form:label path="firstName">First Name</form:label>
					<form:input class="form-control" path="firstName" />
				</div>
				<div class="form-group">
					<form:errors class="text-danger" path="lastName" /><br>
					<form:label path="lastName">Last Name</form:label>
					<form:input class="form-control" path="lastName" />
				</div>
				<div class="form-group">
					<form:errors class="text-danger" path="age" /> <br>
					<form:label path="age">Age</form:label>
					<form:input type="number" class="form-control" path="age" />
				</div>

			</div>
			<button>Nuevo ninja</button>
		</form:form>
	</div>

</body>
</html>
