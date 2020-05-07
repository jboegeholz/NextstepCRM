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
<title><bean:message key="eventlist.name" /></title>
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
</table>
<table>

	<%-- set the header --%>
	<thead>
		<tr>
			<th><bean:message key="event.name" /></th>
			<th>Webseite</th>
			<th>von: </th>
			<th>bis: </th>
			<th><bean:message key="event.typeOfAsset" /></th>
			<th><bean:message key="event.registrationDeadline" /></th>
			<th colspan="3">Aktionen</th>
		</tr>
	</thead>
	<tbody>
		<%-- check if book exists and display message or iterate over books --%>
		<logic:empty name="eventListForm" property="events">
			<tr>
				<td colspan="5"><bean:message key="eventlist.noevents" /></td>

			</tr>
		</logic:empty>
		<logic:notEmpty name="eventListForm" property="events">
			<logic:iterate name="eventListForm" property="events" id="event">
				<tr>
					<td><bean:write name="event" property="name" /></td>
					<td><a href="<c:out value="${event.url}"/>" target="_blank"><c:out value="${event.url}"/></a></td>
					
					<td><bean:write name="event" property="formattedDate" /></td>
					<td><bean:write name="event" property="formattedEndDate" /></td>
					<td><bean:write name="event" property="typeOfAsset" /></td>
					<td><bean:write name="event"
						property="formattedRegistrationDeadline" /></td>


					<td><html:link action="eventDetails.do?do=eventDetails"
						paramName="event" paramProperty="name" paramId="name"
						style="text-decoration:none">
						<html:image src="img/but_zoom.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>
					<td><html:link action="eventEdit.do?do=editEvent"
						paramName="event" paramProperty="name" paramId="name">
						<html:image src="img/but_edit.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>
					<td><html:link action="eventEdit.do?do=deleteEvent"
						paramName="event" paramProperty="name" paramId="name">
						<html:image src="img/but_delete.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>

				</tr>
			</logic:iterate>
		</logic:notEmpty>
	</tbody>
	<%-- print out the add link --%>
	<tfoot>
		<tr>
			<td colspan="7"><html:link action="showAdd.do">
				<html:image src="img/but_plus.gif" border="0" alt="Save">

				</html:image>
			</html:link></td>
		</tr>
	</tfoot>
	<%-- end interate --%>
</table>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>

</body>
</html>
