<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rick and Morty API Results</title>
</head>
<body>
<h1>Rick and Morty API Results</h1>

<%
    // Aquí iría el código Java para obtener los resultados de la API de Rick and Morty
    String characterId = request.getParameter("id"); // Ejemplo: Obtener el ID del personaje
    // Suponiendo que se hace la llamada a la API de Rick and Morty
    String characterInfo = "Data fetched from Rick and Morty API for character ID: " + characterId;
%>

<p><strong>Character ID:</strong> <%= characterId %></p>
<p><strong>Character Info:</strong> <%= characterInfo %></p>

<a href="index.jsp">Go Back</a>
</body>
</html>
