<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 19.02.2015
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
HELLO!!!

<c:if test="${!empty heads}">
  <h3>Users</h3>
  <table>
    <thead>
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${heads}" var="head">
      <tr>
        <td>${head.name}, ${head.birthday}</td>


           <td>

             <c:forEach items="${head.classes}" var="classe">
              ${classe.name}, ${classe.roomNumber} <br/>
             </c:forEach>

           </td>


      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

</body>
</html>
