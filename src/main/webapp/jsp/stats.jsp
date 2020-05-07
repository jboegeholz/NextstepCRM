<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
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
<title>Stats</title>
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
<div id="stats">
<div id="mainnav">
<ul>
  <li><html:link action="default">Home</html:link></li>
  <li><html:link action="applicationList">Bewerbungen</html:link></li>
  <li><html:link action="eventList">Events</html:link></li>
  <li><html:link action="stageActList">Bands / Künstler</html:link></li>
  <li><html:link action="locationList">Locations</html:link></li>
  <li><html:link action="organizerList">Veranstalter</html:link></li>
  <li><html:link styleClass="stats" action="stats">Statistiken</html:link></li>
  <li><html:link action="calendar.do?do=showMonth">Kalendar</html:link></li>
  <li><html:link action="userList">User</html:link></li>
</ul>
</div>
</div>
<div id="contents">
<table>
<thead>
<tr>
<th>Type</th>
<th>gesamt</th>
</tr>
</thead>
<tbody>
<tr>
<td>Bewerbungen</td>
<td><c:out value="${statsForm.numberOfApplications}"/></td>
</tr>
<tr>
<td>Events</td>
<td><c:out value="${statsForm.numberOfEvents}"/></td>
</tr>
<tr>
<td>Bands / Künstler</td>
<td><c:out value="${statsForm.numberOfStageActs}"/></td>
</tr>
<tr>
<td>Locations</td>
<td><c:out value="${statsForm.numberOfLocations}"/></td>
</tr>
<tr>
<td>Veranstalter</td>
<td><c:out value="${statsForm.numberOfEvents}"/></td>
</tr>
<tr>
<td>User</td>
<td><c:out value="${statsForm.numberOfEvents}"/></td>
</tr>
</tbody>
</table>




  <img src="http://chart.apis.google.com/chart?
chs=500x200
&chd=s:Hczaaa
&cht=bvs
&chbh=80
&chxt=x:100
&chl=Bewerbungen|Bands|Events|Locations|Veranstalter|User" /></br>
  <img src="http://chart.apis.google.com/chart?
chs=300x100
&chd=t:50,50
&cht=p3
&chl=Beworben | Unbeworben" /></br>
  <img src="http://chart.apis.google.com/chart?
chs=300x100
&chd=t:20,80
&cht=p3
&chl=Angenommen | Abgelehnt" /></br>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>