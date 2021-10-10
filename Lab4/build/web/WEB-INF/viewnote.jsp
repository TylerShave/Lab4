<%-- 
    Document   : viewnote
    Created on : Oct 6, 2021, 10:11:27 AM
    Author     : 814215
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>View Note</h1>
        <br><br>
        <h2><b>Title: ${titleMessage}</b></h2>
        
        <br><br>
        <h2><b>Contents: ${contentsMessage}</b></h2><br>
        <input type="submit" name="edit" value="Edit note">
    </body>
</html>
