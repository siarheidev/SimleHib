<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form action="forma" method="post" commandName="doubleClass">

    <table>

        <tr>
            <td><form:label path="head.name">Head Name</form:label></td>
            <td><form:input path="head.name"  /></td>
        </tr>
        <tr>
            <td><form:label path="head.tDate">Head tDate</form:label></td>
            <td><form:input type="date" path="head.tDate"  cssStyle="width: 100%" /></td>
        </tr>
        <tr>
            <td><form:label path="classes.name">Classes Name</form:label></td>
            <td><form:input path="classes.name"/></td>
        </tr>
        <tr>
            <td><form:label path="classes.roomNumber" >Classes roomNumber</form:label></td>
            <td><form:input path="classes.roomNumber" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"/></td>
        </tr>

    </table>


</form:form>


</body>
</html>
