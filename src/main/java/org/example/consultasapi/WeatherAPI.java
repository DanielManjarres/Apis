package org.example.consultasapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherAPI {
    private static final String API_KEY = "I35nf4ZA2r";  // Inserta tu API Key aquí

    public static String getWeather(String city) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONObject weatherJson = new JSONObject(response.toString());
                JSONObject main = weatherJson.getJSONObject("main");
                double temp = main.getDouble("temp");
                String description = weatherJson.getJSONArray("weather").getJSONObject(0).getString("description");

                return "Temperature: " + temp + "°C, " + description;
            } else {
                return "Error fetching weather data.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage();
        }
    }
}
