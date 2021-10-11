<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee info</title>
</head>
<body>
<form:form action="saveEmployee" modelAttribute="atr_empl_info">
    <form:hidden path="keyId"/>

    Name<form:input path="firstName"/>
    <br><br>
    Surname<form:input path="lastName"/>
    <br><br>
    Department<form:input path="department"/>
    <br><br>
    Salary<form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK"/>
    <br><br>
</form:form>
</body>
</html>
