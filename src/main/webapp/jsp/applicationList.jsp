<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title>Bewerbungen</title>
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
<div id="application">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link styleClass="application" action="applicationList">Bewerbungen</html:link></li>
	<li><html:link action="eventList">Events</html:link></li>
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
<tbody>
	<tr>
		<td>Filter</td>
		<td><select name="filter">
			<option>Standard</option>
		</select></td>
		<td>Ansicht</td>
		<td><select name="view">
			<option>Standard</option>
		</select></td>
		<td>Anzahl Datensaetze</td>
		<td><select name="number">
			<option>10</option>
			<option>15</option>
			<option>25</option>
			<option>50</option>
		</select></td>
	</tr>
	</tbody>
</table>
<table>
	<thead>
		<tr>
			<th>Booker</th>
			<th>Bewerbungsdatum</th>
			<th>Status</th>
			<th>Künstler</th>
			<th>Veranstaltung</th>
			<th>Location</th>
			<th>Veranstalter</th>
			<th colspan="3" align="center">Aktionen</th>

		</tr>
	</thead>
	<tbody>
		<logic:empty name="applicationListForm" property="applications">
			<tr>
				<td colspan="9">keine Bewerbungen angelegt</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="applicationListForm" property="applications">
			<logic:iterate name="applicationListForm" property="applications"
				id="app">
				<tr>
					<td><c:out value="${app.booker.username}" /></td>
					<td><bean:write name="app" property="formattedSendDate" /></td>
					<td><c:out value="${app.status}" /></td>
					<td><c:out value="${app.stageAct.name}" /></td>
					<td><c:out value="${app.event.name}" /></td>
					<td>
					<c:choose>
        <c:when test='${app.event.location != null}'>
            <c:out value="${app.event.location.name}" />
        </c:when>
        <c:otherwise>
            <c:out value="${app.location.name}" />
        </c:otherwise>
    </c:choose>
					</td>
					<td><c:out value="${app.event.organizer.name}" /></td>
					<td><html:link action="applicationDetails.do?do=applicationDetails"
						paramName="app" paramProperty="id" paramId="id"
						style="text-decoration:none">
						<html:image src="img/but_zoom.gif" border="0" alt="Details">
						</html:image>
					</html:link></td>
					<td><html:link action="applicationEdit.do?do=editApplication"
						paramName="app" paramProperty="id" paramId="id">
						<html:image src="img/but_edit.gif" border="0" alt="Edit">
						</html:image>
					</html:link></td>
					<td><html:link action="applicationEdit.do?do=deleteApplication"
						paramName="app" paramProperty="id" paramId="id">
						<html:image src="img/but_delete.gif" border="0" alt="Delete">
						</html:image>
					</html:link></td>
			</logic:iterate>
		</logic:notEmpty>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="10"><html:link
				action="applicationAdd.do?do=addApplication">
				<html:image src="img/but_plus.gif" border="0" alt="Save">
				</html:image>
			</html:link></td>
		</tr>
	</tfoot>
</table>

</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>