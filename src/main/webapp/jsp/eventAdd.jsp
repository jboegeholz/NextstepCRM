<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<title><bean:message key="eventadd.name" /></title>
<script language="JavaScript" src="calendar1.js"></script>
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
<div id="location">
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

<ul>
	<html:messages id="message">
		<li><bean:write name="message" /></li>
	</html:messages>
</ul>
<html:form action="eventAdd" focus="name">

	<br>

	<%-- print out the form data --%>
	<table border="1">
		<tr>
			<td><bean:message key="event.name" />*</td>
			<td><html:text property="name" /></td>
		</tr>
		<tr>
			<td><bean:message key="location.website" /></td>
			<td><html:text property="url" /></td>
		</tr>
		<tr>
			<td>Startdatum</td>
			<td><html:text readonly="true" value="" property="date" /><a
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
			<td><html:text readonly="true" value=""
				property="registrationDeadline" /><a
				href="javascript:cal1.popup();"><img src="img/cal.gif"
				width="16" height="16" border="0"
				alt="Click Here to Pick up the date"></a></td>
		</tr>
		<tr>
			<td colspan="2"><html:image src="img/but_save.gif" border="0"
				alt="Save">
				<bean:message key="action.save" />
			</html:image></td>
		</tr>

	</table>
	<%-- set the parameter for the dispatch action --%>
	<html:hidden property="do" value="saveEvent" />
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