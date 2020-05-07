
<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<title><bean:message key="eventedit.name" /></title>
<script language="JavaScript" src="calendar1.js"></script>
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
<div id="contents"><html:form action="eventEdit">
	<%-- print out the form data --%>
	<table border="1">
		<tr>
			<td><bean:message key="event.name" /></td>
			<td><c:out value="${eventEditForm.event.name}" /></td>
		</tr>
		<tr>
			<td>Webseite</td>
			<td><html:text property="url" /></td>
		</tr>
		<tr>
			<td>Startdatum</td>
			<td><html:text readonly="true" property="date" /><a
				href="javascript:cal2.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
		</tr>

		<tr>
			<td>Enddatum</td>
			<td><html:text readonly="true" value="" property="endDate" /><a
				href="javascript:cal3.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
		</tr>
		<tr>
			<td><bean:message key="event.typeOfAsset" /></td>
			<td><html:select property="typeOfAsset">
				<html:option value="Festival">Festival</html:option>
				<html:option value="Club">Club</html:option>
				<html:option value="Jugendzentrum">Jugendzentrum</html:option>
				<html:option value="InStorePerformance">InStorePerformance</html:option>
				<html:option value="Wettbewerb">Wettbewerb</html:option>
			</html:select></td>
		</tr>

		<tr>
			<td><bean:message key="event.registrationDeadline" /></td>
			<td><html:text readonly="true" property="registrationDeadline" /><a
				href="javascript:cal1.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>

		</tr>
		<tr>
			<td colspan="2"><bean:message key="location" /></td>
		</tr>
		<logic:notPresent name="eventEditForm" property="location">
			<tr>
				<td>Veranstaltungsort hinzufuegen</td>
				<td><html:select property="locationName">
					<html:option value=""></html:option>
					<c:forEach var="item" items="${eventEditForm.locations}">
						<option><c:out value="${item.name}" /></option>
					</c:forEach>
				</html:select></td>
			</tr>
		</logic:notPresent>
		<logic:present name="eventEditForm" property="location">
			<tr>
				<td>Veranstaltungsort aendern von: <c:out
					value="${eventEditForm.location.name}" /> nach:</td>
				<td><html:select property="locationName">
					<c:forEach var="item" items="${eventEditForm.locations}">
						<c:choose>
							<c:when test="${item.name eq eventEditForm.location.name}">
								<option selected="selected"><c:out value="${item.name}" /></option>
							</c:when>
							<c:otherwise>
								<option><c:out value="${item.name}" /></option>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</html:select></td>
			</tr>
		</logic:present>
		<logic:notPresent name="eventEditForm" property="organizer">
			<tr>
				<td>Veranstalter hinzufuegen</td>
				<td><html:select property="organizerName">
					<html:option value=""></html:option>
					<c:forEach var="item" items="${eventEditForm.organizers}">
						<option><c:out value="${item.name}" /></option>
					</c:forEach>
				</html:select></td>
			</tr>
		</logic:notPresent>
		<logic:present name="eventEditForm" property="organizer">
			<tr>
				<td>Veranstalter aendern von: <c:out
					value="${eventEditForm.organizer.name}" /> nach:</td>
				<td><html:select property="organizerName">
					<c:forEach var="item" items="${eventEditForm.organizer}">
						<option><c:out value="${item.name}" /></option>
					</c:forEach>
				</html:select></td>
			</tr>
		</logic:present>
		<tr>

			<td><html:image src="img/but_save.gif" border="0" alt="Save">
				<bean:message key="action.save" />
			</html:image></td>
			<td><html:link
				action="eventEdit.do?do=updateEventAndAddLocation"
				paramName="eventEditForm" paramProperty="name" paramId="name">
Neuer Veranstaltungsort
			</html:link></td>
		</tr>

	</table>
	<%-- hidden field that contains the id of the book --%>
	<html:hidden property="name" />

	<%-- set the parameter for the dispatch action --%>
	<html:hidden property="do" value="updateEvent" />
</html:form></div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>

<script language="JavaScript">
	var cal1 = new calendar1(document.forms['eventEditForm'].elements['registrationDeadline']);
	cal1.year_scroll = true;
	cal1.time_comp = false;
	var cal2 = new calendar1(document.forms['eventEditForm'].elements['date']);
	cal2.year_scroll = true;
	cal2.time_comp = false;
	    var cal3 = new calendar1(document.forms['eventEditForm'].elements['endDate']);
  cal3.year_scroll = true;
  cal3.time_comp = false;

</script>
</body>
</html>
