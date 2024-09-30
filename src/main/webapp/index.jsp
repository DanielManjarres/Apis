<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>API Selector</title>
</head>
<body>
<h1>Choose an API</h1>
<form action="api" method="get">
    <input type="radio" id="weather" name="api" value="weather">
    <label for="weather">Weather API</label><br>
    <input type="radio" id="rickmorty" name="api" value="rickmorty">
    <label for="rickmorty">Rick and Morty API</label><br>
    <input type="radio" id="trm" name="api" value="trm">
    <label for="trm">TRM-Colombia API</label><br><br>
    <input type="submit" value="Go">
</form>
</body>
</html>
