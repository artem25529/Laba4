<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h2>Input 10 messages</h2>
<form action="<c:url value="/mdb"/>">
    <c:forEach begin="1" end="10" varStatus="status">
        ${status.index}: <input name="messages"><br/>
    </c:forEach>
    <input type="submit" value="send"/>
</form>
</body>
</html>
