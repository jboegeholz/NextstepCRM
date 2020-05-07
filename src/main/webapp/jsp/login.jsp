<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet1.css" media="screen">
<title>Login</title>
</head>
<body>
<div id="container">
<div id="header">
<h1>Sitename</h1>
</div>
<div id="mainnav">
</div>
<div id="contents">
  <ul>
  <html:messages id="message">
     <li><bean:write name="message"/></li>
  </html:messages>
  </ul>
<html:form action="loginsubmit.do" focus="username">
	<table>
		<tr>
			<td><bean:message key="prompt.username" /></td>
			<td><html:text property="username" /></td>
		</tr>
		<tr>
			<td><bean:message key="prompt.password" /></td>
			<td><html:password property="password" /></td>
		</tr>
		<tr>
			<td><html:submit>
				<bean:message key="button.submit" />
			</html:submit></td>
		</tr>
	</table>
</html:form>
</div>
<div id="footer"><a href="#">Copyright © creatronix 2008</a></div>
</div>
</body>
</html>