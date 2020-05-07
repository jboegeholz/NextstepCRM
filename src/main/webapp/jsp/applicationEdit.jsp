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
<script language="JavaScript" src="calendar1.js"></script>
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title>Bewerbung bearbeiten</title>
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
<div id="contents"><html:form action="applicationEdit"
	focus="name">
	<ul>
		<html:messages id="message">
			<li><bean:write name="message" /></li>
		</html:messages>
	</ul>
	<table>
		<thead>
			<th colspan=2>Allgemein</th>
			<th>Nummer:</th>
			<th><html:text readonly="true" property="id"/></th>
		</thead>
		<tr>
			<td>Booker</td>
			<td><html:select property="bookerName">

				<c:forEach var="item" items="${applicationEditForm.allUser}">
					<c:choose>
						<c:when
							test="${item.username eq applicationEditForm.application.booker.username}">
							<option selected="selected"><c:out
								value="${item.username}" /></option>
						</c:when>
						<c:otherwise>
							<option><c:out value="${item.username}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</html:select></td>
			<td>Künstler</td>
			<td><html:select property="stageActName">
				<c:forEach var="item" items="${applicationEditForm.allStageActs}">
					<c:choose>
						<c:when
							test="${item.name eq applicationEditForm.application.stageAct.name}">
							<option selected="selected"><c:out value="${item.name}" /></option>
						</c:when>
						<c:otherwise>
							<option><c:out value="${item.name}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</html:select></td>
		</tr>
		<tr>
			<td>Bewerbungsdatum</td>
			<td><html:text readonly="true" property="sendDate" /><a
				href="javascript:cal1.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
			<td>Status</td>
			<td><html:select property="status">
				<c:forEach var="status" items="${applicationEditForm.applicationStati}">
					<c:choose>
						<c:when
							test="${status eq applicationEditForm.application.status}">
							<option selected="selected"><c:out value="${status}" /></option>
						</c:when>
						<c:otherwise>
							<option><c:out value="${status}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</html:select></td>
		</tr>
		<tr>
			<td>Bewerbungsform</td>
			<td><select name="artist">
				<option value="Post">Post</option>
				<option value="Email">Email</option>
				<option value="Webform">Webform</option>
			</select></td>
		</tr>
		<tr>
			<td>Art der Bewerbung</td>

		</tr>

		<tr>

			<td>Location / Initiativ</td>
			<td><html:select property="locationName">
				<option></option>
				<c:forEach var="item" items="${applicationEditForm.allLocations}">
					<c:choose>
						<c:when
							test="${item.name eq applicationEditForm.application.location.name}">
							<option selected="selected"><c:out value="${item.name}" /></option>
						</c:when>
						<c:otherwise>
							<option><c:out value="${item.name}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</html:select></td>
			<td>Termin (bei Initiativ)</td>
			<td><html:text readonly="true" property="desiredDate" /><a
				href="javascript:cal4.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
		</tr>
		<tr>
			<td>Event</td>
			<td><html:select property="eventName">
				<option></option>
				<c:forEach var="item" items="${applicationEditForm.allEvents}">
					<c:choose>
						<c:when
							test="${item.name eq applicationEditForm.application.event.name}">
							<option selected="selected"><c:out value="${item.name}" /></option>
						</c:when>
						<c:otherwise>
							<option><c:out value="${item.name}" /></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</html:select></td>
		</tr>



	</table>
	<table>
		<thead>
			<th colspan=4>Plakate und Flyer</th>
		</thead>
		<tr>
			<td>angefragt am:</td>
			<td><html:text readonly="true"
				property="askedForPosterAndFlyerDate" /><a
				href="javascript:cal2.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
			<td>abgeschickt am:</td>
			<td><html:text readonly="true" property="sendPosterAndFlyerDate" /><a
				href="javascript:cal3.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
		</tr>
		<tr>
			<td>Anzahl Flyer</td>
			<td><html:text readonly="false" value=""
				property="numberOfSentFlyers" /></td>
			<td>Anzahl Plakate</td>
			<td><html:text readonly="false" value=""
				property="numberOfSentPosters" /></td>
		</tr>
	</table>
	<table>
		<thead>
			<th colspan=4>Gage Spesen</th>
		</thead>
		<tr>
			<td>Gagenvorgabe</td>
			<td><html:text readonly="false" property="demandedFee" /></td>
			<td>erhaltene Gage</td>
			<td><html:text readonly="false"  property="receivedFee" /></td>
		</tr>
		<tr>
			<td>Unterkunft</td>
			<td><html:text readonly="false" 
				property="lodgingCosts" /></td>
			<td>erhaltene Spesen</td>
			<td><html:text readonly="false" 
				property="receivedExpenses" /></td>
		</tr>
		<tr>
			<td>Spritkosten</td>
			<td><html:text readonly="false" 
				property="transportationCosts" /></td>
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
				<td><html:textarea property="comment" rows="8" cols="80"></html:textarea></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td colspan="2"><html:image src="img/but_save.gif" border="0"
				alt="Save">
				<bean:message key="action.save" />
			</html:image></td>
		</tr>

	</table>
	
	<html:hidden property="do" value="updateApplication" />
</html:form></div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
<script language="JavaScript">
  var cal1 = new calendar1(document.forms['applicationEditForm'].elements['sendDate']);
  cal1.year_scroll = true;
  cal1.time_comp = false;
    var cal2 = new calendar1(document.forms['applicationEditForm'].elements['askedForPosterAndFlyerDate']);
  cal2.year_scroll = true;
  cal2.time_comp = false;
   var cal3 = new calendar1(document.forms['applicationEditForm'].elements['sendPosterAndFlyerDate']);
  cal3.year_scroll = true;
  cal3.time_comp = false;
     var cal4 = new calendar1(document.forms['applicationEditForm'].elements['desiredDate']);
  cal4.year_scroll = true;
  cal4.time_comp = false;

</script>
</body>
</html>