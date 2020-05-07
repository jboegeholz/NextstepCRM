<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="month.overview"></bean:message></title>
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
	<li><html:link styleClass="calendar"
		action="calendar.do?do=showMonth">Kalendar</html:link></li>
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

<table class=calendartable border=1 cellpadding=2 cellspacing=0>
	<tr class=calheaderrow>
		<td align=center colspan=7 class=calheadercell>
		<h1 align=center class=calheader><bean:message
			key="month.${calendarForm.monthNames[calendarForm.selectedMonth]}"></bean:message>
		<c:out value='${calendarForm.selectedYear}' /></h1>
		</td>
	</tr>
	<tr>
		<td align=center colspan=7 class=calheadercell><html:form
			action="/calendar.do?do=showMonth">
			<b><bean:message key="month.jump_to_month"></bean:message></b>
			<html:select property="selectedMonth" onchange="this.form.submit()">
				<html:option value="1">
					<bean:message key="month.january"></bean:message>
				</html:option>
				<html:option value="2">
					<bean:message key="month.february"></bean:message>
				</html:option>
				<html:option value="3">
					<bean:message key="month.march"></bean:message>
				</html:option>
				<html:option value="4">
					<bean:message key="month.april"></bean:message>
				</html:option>
				<html:option value="5">
					<bean:message key="month.may"></bean:message>
				</html:option>
				<html:option value="6">
					<bean:message key="month.june"></bean:message>
				</html:option>
				<html:option value="7">
					<bean:message key="month.july"></bean:message>
				</html:option>
				<html:option value="8">
					<bean:message key="month.august"></bean:message>
				</html:option>
				<html:option value="9">
					<bean:message key="month.september"></bean:message>
				</html:option>
				<html:option value="10">
					<bean:message key="month.october"></bean:message>
				</html:option>
				<html:option value="11">
					<bean:message key="month.november"></bean:message>
				</html:option>
				<html:option value="12">
					<bean:message key="month.december"></bean:message>
				</html:option>
			</html:select>

			<html:select property="selectedYear" onchange="this.form.submit()">
				<html:option value="${calendarForm.selectedYear - 1 }">${calendarForm.selectedYear - 1}</html:option>
				<html:option value="${calendarForm.selectedYear}">${calendarForm.selectedYear}</html:option>
				<c:forEach var="i" begin="1" end="3">
					<html:option value="${calendarForm.selectedYear + i}">${calendarForm.selectedYear + i}</html:option>
				</c:forEach>
			</html:select>
		</html:form> <html:form action="/calendar.do?do=addOffDay">
			<b class=jumptomonth>Neuer Off-Day für <%
				out.println(user.getUsername());
			%>
			</b>
			<html:select property="selectedDay">
				<c:forEach var="i" begin="1" end="31">
					<html:option value="${i}">${i}</html:option>
				</c:forEach>
			</html:select>

			<html:select property="selectedMonth">
				<html:option value="1">
					<bean:message key="month.january"></bean:message>
				</html:option>
				<html:option value="2">
					<bean:message key="month.february"></bean:message>
				</html:option>
				<html:option value="3">
					<bean:message key="month.march"></bean:message>
				</html:option>
				<html:option value="4">
					<bean:message key="month.april"></bean:message>
				</html:option>
				<html:option value="5">
					<bean:message key="month.may"></bean:message>
				</html:option>
				<html:option value="6">
					<bean:message key="month.june"></bean:message>
				</html:option>
				<html:option value="7">
					<bean:message key="month.july"></bean:message>
				</html:option>
				<html:option value="8">
					<bean:message key="month.august"></bean:message>
				</html:option>
				<html:option value="9">
					<bean:message key="month.september"></bean:message>
				</html:option>
				<html:option value="10">
					<bean:message key="month.october"></bean:message>
				</html:option>
				<html:option value="11">
					<bean:message key="month.november"></bean:message>
				</html:option>
				<html:option value="12">
					<bean:message key="month.december"></bean:message>
				</html:option>
			</html:select>

			<html:select property="selectedYear">
				<html:option value="${calendarForm.selectedYear - 1 }">${calendarForm.selectedYear - 1}</html:option>
				<html:option value="${calendarForm.selectedYear}">${calendarForm.selectedYear}</html:option>
				<c:forEach var="i" begin="1" end="3">
					<html:option value="${calendarForm.selectedYear + i}">${calendarForm.selectedYear + i}</html:option>
				</c:forEach>


			</html:select>
			<html:submit>

			</html:submit>
		</html:form></td>
	</tr>


	<tr>
		<c:forEach var="i" begin="1" end="7">
			<th class=caldayth><bean:message
				key="day.${calendarForm.dayNames[i]}"></bean:message></th>
		</c:forEach>
	</tr>



	<c:forEach var="i" begin="1" end="${calendarForm.monthStart -1 }"
		step="1">
		<td class=fillerday width=100 height=100 valign="top"></td>
	</c:forEach>

	<c:forEach var="i" begin="1" end="${calendarForm.daysInMonth}" step="1">

		<c:set var="day_of_week" value="${calendarForm.monthStart + i -1}" />

		<c:if test='${day_of_week % 7 eq 1}'>
			<tr class=calendarrow>
		</c:if>

		<td class=calendarday width=100 height=100 valign="top"><html:link
			action="calendar.do?do=showDay&day=${i}">${i}</html:link><br>
		<c:set var="currentSet" value="${calendarForm.testSetsSet[i - 1]}" />
		<c:forEach var="event" items="${currentSet}">
			<font size=-2> <html:link action="${event.linkAction}"
				paramName="event" paramProperty="name" paramId="name"
				style="text-decoration:none">
						${event.type}: ${event.name}
					</html:link> 
			<c:if test='${event.status != null}'>
				<c:choose>
					<c:when
						test='${event.status eq "unklar / offen"}'>
						<img alt="unklar / offen" title="unklar / offen" src="img/yellow_dot.gif">
					</c:when>
					<c:when
						test='${event.status eq "abgesagt / erledigt"}'>
						<img alt="abgesagt / erledigt" title="abgesagt / erledigt" src="img/red_dot.gif">
					</c:when>
					<c:otherwise>
						<img alt="gebucht und / oder abgespielt" title="gebucht und / oder abgespielt" src="img/green_dot.gif">
					</c:otherwise>
				</c:choose>
			</c:if> <br/>
			</font>
		</c:forEach></td>
		<c:if test='${day_of_week % 7 eq 0}'>
			</tr>
		</c:if>
	</c:forEach>

	<c:forEach var="i" begin="1"
		end="${7 - (calendarForm.daysInMonth + calendarForm.monthStart - 1) % 7 }"
		step="1">
		<td class=endfillerday width=100 height=100 valign="top"></td>
	</c:forEach>
</table>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>


</body>
</html>