package org.aes.searchnode;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class OxfordAPITest {


    final String language = "en-gb";
    final String word = "Ace";
    final String fields = "pronunciations";
    final String strictMatch = "false";
    final String word_id = word.toLowerCase();
    final String restUrl = "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    //TODO: replace with your own app id and app key
    final String app_id = "47025a28";
    final String app_key = "78a49e9e2442aa9708c094c68c907820";

    public OxfordAPITest() {
        try {
            URL url = new URL(restUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();


        }
    }
}
