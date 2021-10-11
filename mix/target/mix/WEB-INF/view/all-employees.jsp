<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>All Employees</h1>
    <br>

    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Operations</th>

        </tr>

        <c:forEach var="var1" items="${atr_list_employees}">

            <c:url var="updateButton" value="/updateInfo">
                <c:param name="empl_id" value="${var1.keyId}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="empl_id" value="${var1.keyId}"/>
            </c:url>

            <tr>
                <td>${var1.firstName}</td>

                <td>${var1.lastName}</td>

                <td>${var1.department}</td>

                <td>${var1.salary}</td>

                <td>
                    <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>
                    <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>

    </table>

    <br>
    <input type="button" value="Add" onclick="window.location.href='addEmployee'"/>

</body>
</html>
