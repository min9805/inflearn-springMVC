<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>

<!-- ((Member)request.getAttribute("member")).getID().. 이런식으로 해야하지만 JSP 가 제공하는 표준식을 사용할 수 있다 -->
    <body> 성공
        <ul>
              <li>id=${member.id}</li>
              <li>username=${member.username}</li>
              <li>age=${member.age}</li>
        </ul>
        <a href="/index.html">메인</a>
    </body>
</html>