<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Weather API Results</title>
</head>
<body>
<h1>Weather API Results</h1>

<%
    // Aquí iría el código Java para obtener los resultados de la API del clima
    String city = request.getParameter("city"); // Ejemplo: Obtener la ciudad de los parámetros
    // Suponiendo que se hace la llamada a la API del clima
    String weatherResult = "Data fetched from Weather API for city: " + city;
%>

<p><strong>City:</strong> <%= city %></p>
<p><strong>Weather Info:</strong> <%= weatherResult %></p>

<a href="index.jsp">Go Back</a>
</body>
</html>
