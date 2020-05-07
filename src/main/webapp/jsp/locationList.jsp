<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title><bean:message key="locationlist.name" /></title>
</head>
<body>
<%
	User user = (User) request.getSession().getAttribute("user");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<div id="container">
<div id="header">
<div id="login">logged in as: <%
	out.println(user.getUsername());
%> <html:link action="logout.do">Log off</html:link></div>
<h1>Sitename</h1>
</div>
<div id="location">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link action="applicationList">Bewerbungen</html:link></li>
	<li><html:link action="eventList">Events</html:link></li>
	<li><html:link action="stageActList">Bands / Künstler</html:link></li>
	<li><html:link styleClass="location" action="locationList">Locations</html:link></li>
	<li><html:link action="organizerList">Veranstalter</html:link></li>
	<li><html:link action="stats">Statistiken</html:link></li>
	<li><html:link action="calendar.do?do=showMonth">Kalendar</html:link></li>
	<li><html:link action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents">
<table>
	<thead>
		<tr>
		<th><bean:message key="address.town" /></th>
			<th><bean:message key="location.name" /></th>
			<th><bean:message key="location.website" /></th>
			<th colspan="3">Aktionen</th>
		</tr>
	</thead>
	<tbody>
		<logic:empty name="locationListForm" property="locations">
			<tr>
				<td colspan="5"><bean:message key="locationlist.nolocations" /></td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="locationListForm" property="locations">
			<logic:iterate name="locationListForm" property="locations"
				id="location">
				<tr>
					<td><c:out value="${location.address.town}" /></td>
					<td><bean:write name="location" property="name" /></td>
					<td><a href="<c:out value="${location.url}"/>" target="_blank"><c:out value="${location.url}"/></a></td>
					<td><html:link action="locationDetails.do?do=locationDetails"
						paramName="location" paramProperty="name" paramId="name">
						<html:image src="img/but_zoom.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>
					<td><html:link action="locationEdit.do?do=editLocation"
						paramName="location" paramProperty="name" paramId="name">
						<html:image src="img/but_edit.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>
					<td><html:link action="locationEdit.do?do=deleteLocation"
						paramName="location" paramProperty="name" paramId="name">
						<html:image src="img/but_delete.gif" border="0" alt="Save">
						</html:image>
					</html:link></td>
				</tr>


			</logic:iterate>
		</logic:notEmpty>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6"><html:link action="showAddLocation.do">
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