<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Message</title>
    </head>
    <body>
        <form action="<c:url value="/mdb"/>">
            Enter your message: <input name="message"><br/>
            <input type="submit" value="send"/>
        </form>
    </body>
</html>
