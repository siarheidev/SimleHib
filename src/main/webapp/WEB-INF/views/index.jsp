<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>HELLO!!!</h2>

<c:if test="${!empty heads}">
  <h3>Users</h3>
  <table border="2" align="center" cellspacing="0">
    <thead>
    <tr>
      <th>Head</th>
      <th>Classes</th>
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
