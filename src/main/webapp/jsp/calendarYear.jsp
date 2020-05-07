<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String[] monthname = { "", "January", "February", "March", "April",
        "May", "June", "July", "August", "September", "October",
        "November", "December" };
pageContext.setAttribute("monthname", monthname);
  String[] day = { "", "Monday", "Tuesday", "Wednesday", "Thursday",
      "Friday", "Saturday", "Sunday" };
%>

<table>
<tr>
    <%
      for (int i = 1; i < 8; i++) {
    %>
    <th class=caldayth><%=day[i]%></th>
    <%
      }
    %>
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

    <td class=calendarday width=100 height=100 valign="top"><a
      class=daylink href="calendarMonth.do?do=showDay">${i}</a><br>
    </td>
    <c:if test='${day_of_week % 7 eq 0}'>
      </tr>
    </c:if>
  </c:forEach>
</table>
</body>
</html>