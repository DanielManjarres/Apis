<%@ page import="org.example.consultasapi.TRMColombiaAPI" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TRM Colombia API Results</title>
</head>
<body>
<h1>TRM Colombia API Results</h1>

<p><strong>TRM Info:</strong> <%= TRMColombiaAPI.getTRM() %></p>

<a href="index.jsp">Go Back</a>
</body>
</html>
