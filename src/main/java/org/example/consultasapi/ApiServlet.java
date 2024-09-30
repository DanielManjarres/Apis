package org.example.consultasapi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/v1")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String apiType = request.getParameter("api");

        if (apiType == null) {
            response.getWriter().println("No API selected.");
            return;
        }

        switch (apiType) {
            case "weather":
                String city = request.getParameter("city");
                if (city == null) city = "Bogotá"; // Default city
                String weatherData = WeatherAPI.getWeather(city);
                response.getWriter().println(weatherData);
                break;

            case "rickmorty":
                int characterId = Integer.parseInt(request.getParameter("id"));
                String characterData = RickAndMortyAPI.getCharacter(characterId);
                response.getWriter().println(characterData);
                break;

            case "trm":
                String trmData = TRMColombiaAPI.getTRM();
                response.getWriter().println(trmData);
                break;

            default:
                response.getWriter().println("Invalid API selection.");
                break;
        }
    }
}