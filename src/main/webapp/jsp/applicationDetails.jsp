<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title>Bewerbungsdetails</title>
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
	<thead>
		<th colspan=4>Allgemein</th>
		<tr>
			<td>Booker</td>
			<td><c:out
				value="${applicationDetailsForm.application.booker.username}" /></td>
			<td>Künstler</td>
			<td><c:out
				value="${applicationDetailsForm.application.stageAct.name}" /></td>
		</tr>
		<tr>
			<td>Bewerbungsdatum</td>
			<td><c:out value="${applicationDetailsForm.sendDate}" /></td>
			<td>Status</td>
			<td><c:out value="${applicationDetailsForm.application.status}" /></td>
		</tr>
		<tr>
			<td>Art der Bewerbung</td>
		</tr>
		<c:if test="${applicationDetailsForm.application.location != null}">
			<tr>

				<td>Location / Initiativ</td>
				<td><c:out
					value="${applicationDetailsForm.application.location.name}" /></td>
				<td>Terminvorgabe</td>
				<td><c:out value="${applicationDetailsForm.desiredDate}" /></td>
			</tr>
		</c:if>
		<c:if test="${applicationDetailsForm.application.event != null}">
			<tr>
				<td>Event</td>
				<td><c:out
					value="${applicationDetailsForm.application.event.name}" /></td>
				<td>Termin</td>
				<td><c:out
					value="${applicationDetailsForm.application.event.formattedDate}" /></td>
			</tr>
		</c:if>

	</thead>
</table>
<table>
	<thead>
		<th colspan=4>Plakate und Flyer</th>
	</thead>
	<tr>
		<td>angefragt am:</td>
		<td><c:out
			value="${applicationDetailsForm.askedForPosterAndFlyerDate}" /></td>
		<td>abgeschickt am:</td>
		<td><c:out
			value="${applicationDetailsForm.sendPosterAndFlyerDate}" /></td>
	</tr>
	<tr>
		<td>Anzahl Flyer</td>
		<td><c:out
			value="${applicationDetailsForm.application.numberOfSentFlyers}" /></td>
		<td>Anzahl Plakate</td>
		<td><c:out
			value="${applicationDetailsForm.application.numberOfSentPosters}" /></td>
	</tr>
</table>
<table>
	<thead>
		<th colspan=4>Gage Spesen</th>
	</thead>
	<tr>
		<td>Gagenvorgabe</td>
		<td><c:out
			value="${applicationDetailsForm.application.demandedFee}" /></td>
		<td>erhaltene Gage</td>
		<td><c:out
			value="${applicationDetailsForm.application.receivedFee}" /></td>
	</tr>
	<tr>
		<td>Unterkunft</td>
		<td><c:out
			value="${applicationDetailsForm.application.lodgingCosts}" /></td>
		<td>erhaltene Spesen</td>
		<td><c:out
			value="${applicationDetailsForm.application.receivedExpenses}" /></td>
	</tr>
	<tr>
		<td>Spritkosten</td>
		<td><c:out
			value="${applicationDetailsForm.application.transportationCosts}" /></td>
		<td>Zahlungskonditionen</td>
		<td><select name="artist">
			<option value="bar, vor Auftritt">bar, vor Auftritt</option>
			<option value="bar, nach Auftritt">bar, nach Auftritt</option>
			<option value="Überweisung">Überweisung</option>
		</select></td>
	</tr>
</table>
<table>
	<thead>
		<tr>
			<th>Kommentar</th>
		</tr>
	</thead>

	<tbody>
		<tr>
			<td><textarea readonly="readonly" rows="8" cols="80"><c:out
				value="${applicationDetailsForm.application.comment}" /></textarea></td>
		</tr>
	</tbody>
</table>

</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>