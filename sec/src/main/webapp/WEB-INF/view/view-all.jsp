<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: unit
  Date: 16.10.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Information for all employee</h2>
<br><br>
<br><br>

<security:authorize access="hasRole('XR')">
<input type="button" value="Salary" onclick="window.location.href='hr_info'">
Only forHR staff
</security:authorize>

<br><br>
<br><br>

<security:authorize access="hasRole('XY')">
<input type="button" value="Performance" onclick="window.location.href='manager_info'">
Only forManager staff
</security:authorize>

</body>
</html>
