<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>TicketBooking-Project</title>


</head>

<body>
<h2>Add Show</h2>
<form:form method="POST" action="/web/createShow" modelAttribute="movieShowForm">
<table>
<tr>
<td colspan = "2">
<form:select path = "movieId">
<form:option value = "NONE" label = "Select Movie"/>
<c:forEach var="movie" items="${moviesList}" varStatus="loop">
<form:option value="${movie.id}" label="${movie.movieName}-${movie.language}" />
</c:forEach>
</form:select> 
</td>
</tr>
<tr>
<td colspan = "2">
<form:select path = "theatreScreenId">
<form:option value = "NONE" label = "Select Theatre & Screen"/>
<c:forEach var="screen" items="${screenList}" varStatus="loop">
<c:set var="theatre" value="${screen.theatre}"/>
<form:option value="${screen.id}" 
	label="${theatre.name}-${screen.screenName}"/>
</c:forEach>
</form:select>
</td>
</tr>
<tr>
<td><form:label path = "showTime">Show Time</form:label></td>
<td><form:input path = "showTime" required="true"/></td>
</tr>
<tr>
<td><form:label path = "showDate">Show Date(DD-MM-YYYY)</form:label></td>
<td><form:input path = "showDate" required="true"/></td>
</tr>  
<td colspan = "2">
<input type = "submit" value = "Submit"/>
</td>
</tr>
</table>  
</form:form>

</body>
</html>