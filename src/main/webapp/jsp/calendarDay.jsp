<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="day.overview"></bean:message></title>
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
<div id="calendar">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link action="applicationList">Bewerbungen</html:link></li>
	<li><html:link action="eventList">Events</html:link></li>
	<li><html:link action="stageActList">Bands / Künstler</html:link></li>
	<li><html:link action="locationList">Locations</html:link></li>
	<li><html:link action="organizerList">Veranstalter</html:link></li>
	<li><html:link action="stats">Statistiken</html:link></li>
	<li><html:link styleClass="calendar" action="calendar.do?do=showMonth">Kalendar</html:link></li>
	<li><html:link action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents">
<bean:message key="month.${calendarForm.monthNames[calendarForm.selectedMonth]}"></bean:message>
<c:out value="${calendarForm.selectedDay} ${calendarForm.selectedYear}"></c:out>
<br />
<c:set var="currentSet"  value="${calendarForm.testSetsSet[0]}" />
      <c:forEach var="event" items="${currentSet}">
      <html:link action="eventDetails.do?do=eventDetails"
						paramName="event" paramProperty="name" paramId="name" style="text-decoration:none">
						${event.type}: ${event.name}
					</html:link>
      <br>
      </c:forEach>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>


</body>
</html>