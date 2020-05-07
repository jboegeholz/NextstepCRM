<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="eventdetails.name" /></title>
<link rel="stylesheet" href="stylesheet1.css" media="screen">
</head>
<body>
<%
	User user = (User) request.getSession().getAttribute("user");
%>
<div id="container">
<div id="header">
<div id="login">logged in as: <%
	out.println(user.getUsername());
%> <html:link action="logout.do">Log off</html:link></div>
<h1>Sitename</h1>
</div>
<div id="event">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link action="applicationList">Bewerbungen</html:link></li>
	<li><html:link styleClass="event" action="eventList">Events</html:link></li>
	<li><html:link action="stageActList">Bands / Künstler</html:link></li>
	<li><html:link action="locationList">Locations</html:link></li>
	<li><html:link action="organizerList">Veranstalter</html:link></li>
	<li><html:link action="stats">Statistiken</html:link></li>
	<li><html:link action="calendar.do?do=showMonth">Kalendar</html:link></li>
	<li><html:link action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents">
<table>
	<tr>
		<td><bean:message key="event.name" /></td>
		<td><c:out value="${eventDetailsForm.event.name}"/></td>
	</tr>
	<tr>
		<td><bean:message key="location.website" /></td>
		<td><c:out value="${eventDetailsForm.event.url}"/></td>
	</tr>
	<tr>
		<td><bean:message key="event.date" /></td>
		<td><c:out value="${eventDetailsForm.date}"/></td>
	</tr>
	<tr>
		<td><bean:message key="event.typeOfAsset" /></td>
		<td><c:out value="${eventDetailsForm.event.typeOfAsset}"/></td>
	</tr>
	<tr>
		<td><bean:message key="event.registrationDeadline" /></td>
		<td><c:out value="${eventDetailsForm.registrationDeadline}"/></td>
	</tr>
	<tr>
		<td>Location</td>
		<td><c:out value="${eventDetailsForm.event.location.name}"/></td>
	</tr>
</table>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>

</body>
</html>