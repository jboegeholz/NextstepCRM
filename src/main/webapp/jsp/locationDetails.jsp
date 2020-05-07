<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><bean:message key="locationdetails.name" /></title>
<link rel="stylesheet" href="stylesheet1.css" media="screen">
</head>
<body>
<%
	User user = (User) request.getSession().getAttribute("user");
%>
<div id="container">
<div id="header">
<div id="login">logged in as:
<%
	out.println(user.getUsername());

%>
<html:link action="logout.do">Log off</html:link>
</div>
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
<tr>
<td><bean:message key="location.name" /></td>
<td><c:out value="${locationDetailsForm.location.name}"/></td>
</tr>
<tr>
<td><bean:message key="location.website" /></td>
<td><a href="<c:out value="${locationDetailsForm.location.url}"/>" target="_blank"><c:out value="${locationDetailsForm.location.url}"/></a></td>
</tr>
<tr>
<td><bean:message key="address.street" /></td>
<td><bean:write name="locationDetailsForm" property="locationStreet" /></td>
</tr>
<tr>
<td><bean:message key="address.streetno" /></td>
<td><bean:write name="locationDetailsForm" property="locationStreetNo" /></td>
</tr>
<tr>
<td><bean:message key="address.zipcode" /></td>
<td><bean:write name="locationDetailsForm" property="locationZipCode" /></td>
</tr>
<tr>
<td><bean:message key="address.town" /></td>
<td><bean:write name="locationDetailsForm" property="locationTown" /></td>
</tr>
<tr>
<td><bean:message key="address.country" /></td>
<td><bean:write name="locationDetailsForm" property="locationCountry" /></td>
</tr>
</table>
<!-- area for location contact person -->
<bean:message key="location.contact" />
<logic:empty name="locationDetailsForm" property="locationContacts">
<tr>
<td colspan="5">No contacts available</td>
</tr>
</logic:empty>
<logic:notEmpty name="locationDetailsForm" property="locationContacts">
<table><tr>
<logic:iterate name="locationDetailsForm" property="locationContacts" id="contact">
<td>
<table>
<tr>
<td><bean:message key="contact.title" /></td>
<td><bean:write name="contact" property="title" /><td>
</tr>
<tr>
<td><bean:message key="contact.firstname" /></td>
<td><bean:write name="contact" property="firstname" /><td>
</tr>
<tr>
<td><bean:message key="contact.surname" /></td>
<td><bean:write name="contact" property="surname" /><td>
</tr>
<tr>
<td><bean:message key="contact.function" /></td>
<td><bean:write name="contact" property="function" /><td>
</tr>
<tr>
<td><bean:message key="contact.details.email" /></td>
<td><a href="mailto:<c:out value="${contact.contactDetails.email}"/>?subject=<c:out value="${locationDetailsForm.location.name}"/>&body=<bean:write name="contact" property="surname" />,"><c:out value="${contact.contactDetails.email}"/></a> </td>
</tr>
<tr>
<td><bean:message key="contact.details.tel" /></td>
<td><c:out value="${contact.contactDetails.landlineNumber}"/><td>
</tr>
<tr>
<td><bean:message key="contact.details.mobile" /></td>
<td><c:out value="${contact.contactDetails.cellPhoneNumber}"/><td>
</tr>
</table>
</td>
</logic:iterate>
</tr></table>
</logic:notEmpty>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>

<!-- <html:text name="locationDetailsForm" property="locationStreet" /> -->
</body>
</html>