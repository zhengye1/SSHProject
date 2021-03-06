<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta name="viewpoint" http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1; width=device-width, initial-scale=1">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/jquery-ui.css' />"
	rel="stylesheet"></link>
<script type="text/javascript"
	src='${pageContext.request.contextPath}/static/js/jquery-3.1.0.min.js'></script>
<script type="text/javascript"
	src='${pageContext.request.contextPath}/static/js/jquery-ui.js'></script>
<script>
	$(document).ready(function() {
		$("#dateOfBirth").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>

		<div class="well lead">User Registration Form</div>
		<form:form method="POST" modelAttribute="user" class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="firstName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="username">Username</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="username" id="username"
									class="form-control input-sm" disabled="true" />
							</c:when>
							<c:otherwise>
								<form:input type="text" path="username" id="username"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="username" class="help-inline" />
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="dateOfBirth">Date
						Of Birth</label>
					<div class="col-md-7">
						<form:input type="text" path="dateOfBirth" id="dateOfBirth"
							class="form-control input-sm dateOfBirth" />
						<div class="has-error">
							<form:errors path="dateOfBirth" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="department">Department</label>
					<div class="col-md-7">
						<form:select path="department">
							<form:options items="${departments}" itemValue="id"
								itemLabel="name" />
						</form:select>
						<div class="has-error">
							<form:errors path="department" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="roles">Roles</label>
					<div class="col-md-7">
						<form:select path="roles" items="${roles}" multiple="true"
							itemValue="id" itemLabel="roleName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="roles" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/list' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/list' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>