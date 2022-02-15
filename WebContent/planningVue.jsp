<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vue Planning</title>
</head>

<body>
<sql:setDataSource var = "tai" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/tai"
         user = "root"  password = ""/>
<h1>Planning</h1>
<table> 
	<thead>

		<th>Nom</th>
		<th>Description</th>
		<th>Date de debut</th>
		<th>Date de fin</th>
		<th>Emargement</th>
	</thead>
	<tbody class="planningEmploye">
			    <c:forEach items="${affectationListe}" var="affectation">
				<tr>
					<td><c:out value="${affectation.nom}"></c:out></td>
					<td><c:out value="${affectation.description}"></c:out></td>
					<td><c:out value="${affectation.date_debut}"></c:out></td>
					<td><c:out value="${affectation.date_fin}"></c:out></td>
					<td><c:out value="${affectation.emargement}"></c:out></td>

					
				</tr>
				</c:forEach>
	</tbody>

</table>

</body>
</html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>