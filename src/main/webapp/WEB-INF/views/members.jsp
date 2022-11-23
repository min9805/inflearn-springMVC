<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSP는 특별한 태그들이 존재해서 loop를 쉽게 출력할 수 있다 -->

  <html>
  <head>
      <meta charset="UTF-8">
      <title>Title</title>
  </head>
<body>
<a href="/index.html">메인</a>
  <table>
      <thead>
      <th>id</th>
      <th>username</th>
      <th>age</th>
      </thead>
      <tbody>
      <c:forEach var="item" items="${members}">
            <tr>
                  <td>${item.id}</td>
                 <td>${item.username}</td>
                 <td>${item.age}</td>
             </tr>
         </c:forEach>
         </tbody>
     </table>
     </body>
     </html>