<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User verwalten</title>
<link rel="stylesheet" href="stylesheet1.css" media="screen">
</head>
<body>
<%
	User loggedInUser = (User) request.getSession().getAttribute("user");
%>
<div id="container">
<div id="header">
<div id="login">logged in as:
<%
	out.println(loggedInUser.getUsername());
%>
<html:link action="logout.do">Log off</html:link>
</div>
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
<div id="contents">
<table border="1">
<logic:empty name="userListForm" property="users">
	<tr>
		<td colspan="5">No user available</td>
	</tr>
</logic:empty>
<logic:notEmpty name="userListForm" property="users">
	<logic:iterate name="userListForm" property="users" id="user">
		<tr>
			<td><bean:write name="user" property="username" /></td>
		</tr>
	</logic:iterate>
</logic:notEmpty>
<tr>
<td colspan="5"><html:link action="userAdd.do?do=addUser">
<bean:message key="user.add"/>
</html:link>
</td>
</tr>
</table>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>


</body>
</html>