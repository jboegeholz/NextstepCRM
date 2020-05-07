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
<title>User hinzufuegen</title>
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
<div id="user">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link action="applicationList">Bewerbungen</html:link></li>
	<li><html:link action="eventList">Events</html:link></li>
	<li><html:link action="stageActList">Bands / Künstler</html:link></li>
	<li><html:link action="locationList">Locations</html:link></li>
	<li><html:link action="organizerList">Veranstalter</html:link></li>
	<li><html:link action="stats">Statistiken</html:link></li>
	<li><html:link action="calendar.do?do=showMonth">Kalendar</html:link></li>
	<li><html:link styleClass="user" action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents"><html:form action="userAdd" focus="username">
	<ul>
		<html:messages id="message">
			<li><bean:write name="message" /></li>
		</html:messages>
	</ul>
	<table>
		<tr>
			<td>Username</td>
			<td><html:text value="" property="username" /></td>
		</tr>
		<tr>
			<td>Passwort</td>
			<td><html:password value="" property="password" /></td>
		</tr>
		<tr>

			<td colspan="2"><html:image src="img/but_save.gif" border="0"
				alt="Save">
				<bean:message key="action.save" />
			</html:image></td>
		</tr>

	</table>
	<%-- set the parameter for the dispatch action --%>
	<html:hidden property="do" value="saveUser" />

</html:form></div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>

</body>
</html>