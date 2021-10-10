<%-- 
    Document   : editnote
    Created on : Oct 6, 2021, 10:11:45 AM
    Author     : 814215
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Title: </h1>
        <input type="text" name="title" value="${titleMessage}">
        <br><br>
        <h1>Contents: </h1>
        <br>
        <input type="text" name="contents" value="${contentsMessage}">
        <input type="submit" name="submitEdit" value="Save">
    </body>
</html>
