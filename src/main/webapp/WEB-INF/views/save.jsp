<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form action="form" method="post" commandName="doubleClass">
  <form:input path="head.name"/>
  <form:input path="classes.head.name"/>
  <input type="submit" value="Create"/>
</form:form>



</body>
</html>
