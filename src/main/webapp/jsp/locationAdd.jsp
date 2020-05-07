<%@ page language="java"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="de.creatronix.artist3k.model.*"%>
<html>
<head>
<title>Veranstaltungsort hinzufügen</title>
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
<div id="location">
<div id="mainnav">
<ul>
	<li><html:link action="default">Home</html:link></li>
	<li><html:link action="applicationList">Bewerbungen</html:link></li>
	<li><html:link action="eventList">Events</html:link></li>
	<li><html:link action="stageActList">Bands / Künstler</html:link></li>
	<li><html:link styleClass="location" action="locationList">Locations</html:link></li>
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
<html:form acceptCharset="UTF-8" action="locationAdd" focus="name">

	<%-- print out the form data --%>
	<table border="1">
		<tr>
			<td><bean:message key="address.town" /> *</td>
			<td><html:text property="locationTown" /></td>
		</tr>
		<tr>
			<td><bean:message key="location.name" /> *</td>
			<td><html:text property="name" /></td>
		</tr>
		<tr>
			<td><bean:message key="location.website" /></td>
			<td><html:text property="url" /></td>
		</tr>
		<tr>
			<td><bean:message key="address.street" /> *</td>
			<td><html:text property="locationStreet" /></td>
		</tr>
		<tr>
			<td><bean:message key="address.streetno" /> *</td>
			<td><html:text property="locationStreetNo" /></td>
		</tr>
		<tr>
			<td><bean:message key="address.zipcode" /> *</td>
			<td><html:text property="locationZipCode" /></td>
		</tr>
		<tr>
			<td><bean:message key="address.country" /></td>
			<td><html:select property="locationCountry">
				<html:option value="	Albanien 	">	Albanien 	</html:option>
				<html:option value="	Andorra 	">	Andorra 	</html:option>
				<html:option value="	Belgien 	">	Belgien 	</html:option>
				<html:option value="	Bosnien und Herzegowina 	">	Bosnien und Herzegowina 	</html:option>
				<html:option value="	Bulgarien 	">	Bulgarien 	</html:option>
				<html:option value="	Dänemark 	">	Dänemark 	</html:option>
				<html:option value="	Deutschland 	">	Deutschland 	</html:option>
				<html:option value="	Estland 	">	Estland 	</html:option>
				<html:option value="	Finnland 	">	Finnland 	</html:option>
				<html:option value="	Frankreich 	">	Frankreich 	</html:option>
				<html:option value="	Griechenland 	">	Griechenland 	</html:option>
				<html:option value="	Irland 	">	Irland 	</html:option>
				<html:option value="	Island 	">	Island 	</html:option>
				<html:option value="	Italien 	">	Italien 	</html:option>
				<html:option value="	Kasachstan	">	Kasachstan	</html:option>
				<html:option value="	Kroatien 	">	Kroatien 	</html:option>
				<html:option value="	Lettland 	">	Lettland 	</html:option>
				<html:option value="	Liechtenstein 	">	Liechtenstein 	</html:option>
				<html:option value="	Litauen 	">	Litauen 	</html:option>
				<html:option value="	Luxemburg 	">	Luxemburg 	</html:option>
				<html:option value="	Malta 	">	Malta 	</html:option>
				<html:option value="	Mazedonien 	">	Mazedonien 	</html:option>
				<html:option value="	Moldawien 	">	Moldawien 	</html:option>
				<html:option value="	Monaco 	">	Monaco 	</html:option>
				<html:option value="	Montenegro 	">	Montenegro 	</html:option>
				<html:option value="	Niederlande 	">	Niederlande 	</html:option>
				<html:option value="	Norwegen 	">	Norwegen 	</html:option>
				<html:option value="	Österreich 	">	Österreich 	</html:option>
				<html:option value="	Polen 	">	Polen 	</html:option>
				<html:option value="	Portugal 	">	Portugal 	</html:option>
				<html:option value="	Rumänien 	">	Rumänien 	</html:option>
				<html:option value="	Russland	">	Russland	</html:option>
				<html:option value="	San Marino 	">	San Marino 	</html:option>
				<html:option value="	Schweden 	">	Schweden 	</html:option>
				<html:option value="	Schweiz 	">	Schweiz 	</html:option>
				<html:option value="	Serbien 	">	Serbien 	</html:option>
				<html:option value="	Slowakei 	">	Slowakei 	</html:option>
				<html:option value="	Slowenien 	">	Slowenien 	</html:option>
				<html:option value="	Spanien 	">	Spanien 	</html:option>
				<html:option value="	Tschechien 	">	Tschechien 	</html:option>
				<html:option value="	Türkei	">	Türkei	</html:option>
				<html:option value="	Ukraine 	">	Ukraine 	</html:option>
				<html:option value="	Ungarn 	">	Ungarn 	</html:option>
				<html:option value="	Vereinigtes Königreich 	">	Vereinigtes Königreich 	</html:option>
				<html:option value="	Weißrussland	">	Weißrussland	</html:option>
			</html:select></td>
		</tr>
		<tr>
			<td>* = Pflichtfelder</td>
			<td><html:image src="img/but_save.gif" border="0" alt="Save">
				<bean:message key="action.save" />
			</html:image></td>

		</tr>

	</table>
	<%-- set the parameter for the dispatch action --%>
	<html:hidden property="do" value="saveLocation" />
</html:form></div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>