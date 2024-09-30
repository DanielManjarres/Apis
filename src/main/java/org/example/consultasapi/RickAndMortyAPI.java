package org.example.consultasapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RickAndMortyAPI {
    public static String getCharacter(int characterId) {
        try {
            String urlString = "https://rickandmortyapi.com/api/character/" + characterId;
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
                JSONObject characterJson = new JSONObject(response.toString());
                String name = characterJson.getString("name");
                String status = characterJson.getString("status");
                String species = characterJson.getString("species");

                return "Name: " + name + ", Status: " + status + ", Species: " + species;
            } else {
                return "Error fetching character data.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage();
        }
    }
}
