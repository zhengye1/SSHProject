<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List in Department</title>
</head>
<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">List of Users Under Department</span>
			</div>
			<table class="table table-hiver table-fixedheader">
				<thead>
					<tr>
						<th width="20%">First name</th>
						<th width="20%">Last name</th>
						<th width="25%">Email</th>
						<th width="15%">Username</th>
						<sec:authorize access="hasRole('ADMIN') or hasRole('LEADER')">
							<th width="10%"></th>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="10%"></th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td width="20%">${user.firstName}</td>
							<td width="20%">${user.lastName}</td>
							<td width="25%">${user.email}</td>
							<td width="15%">${user.username}</td>
							<sec:authorize access="hasRole('ADMIN') or hasRole('LEADER')">
								<td width="10%"><a
									href="<c:url value='/edit-user-${user.username}' />"
									class="btn btn-success custom-width">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td width="10%"><a
									href="<c:url value='/delete-user-${user.username}' />"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>