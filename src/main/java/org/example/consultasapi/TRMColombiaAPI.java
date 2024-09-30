package org.example.consultasapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class TRMColombiaAPI {

    public static String getTRM() {
        try {
            // URL de la API pública de TRM en Colombia
            String urlString = "https://trm-colombia.vercel.app/";
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
                JSONObject trmJson = new JSONObject(response.toString());
                JSONObject trmData = trmJson.getJSONObject("data");

                // Obtener los valores de la TRM y la fecha
                double valorTRM = trmData.getDouble("valor");
                String fechaTRM = trmData.getString("vigencia");

                return "TRM: " + valorTRM + " COP, Vigente hasta: " + fechaTRM;
            } else {
                return "Error fetching TRM data.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage();
        }
    }
}
