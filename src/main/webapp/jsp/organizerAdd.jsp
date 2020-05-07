<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title>Liste der Veranstalter</title>
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
<div id="organizer">
<div id="mainnav">
<ul>
   <li><html:link action="default">Home</html:link></li>
   <li><html:link action="applicationList">Bewerbungen</html:link></li>
   <li><html:link action="eventList">Events</html:link></li>
   <li><html:link action="stageActList">Bands / Künstler</html:link></li>
   <li><html:link action="locationList">Locations</html:link></li>
   <li><html:link styleClass="organizer" action="organizerList">Veranstalter</html:link></li>
   <li><html:link action="stats">Statistiken</html:link></li>
   <li><html:link action="calendar.do?do=showMonth">Kalendar</html:link></li>
   <li><html:link action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents">

</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>