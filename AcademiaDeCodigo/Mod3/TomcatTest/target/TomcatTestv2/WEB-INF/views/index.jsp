<%--
  Created by IntelliJ IDEA.
  User: fabio
  Date: 28/03/21
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Screen</title>
</head>
<body>

<form action="/TomcatTest/" method="post">
    <p>Username:</p>
    <input name="username" type="text" />
    <br>
    <br>
    <p>Password</p>
    <input name="password" type="password" />
    <br>
    <br>
    <input type="submit" value="Submit" />
</form>

${greeting}

</body>
</html>
