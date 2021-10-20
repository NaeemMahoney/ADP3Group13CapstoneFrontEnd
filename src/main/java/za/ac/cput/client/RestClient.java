package za.ac.cput.client;

import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RestClient {
    public void RestClient() {}

    public <T> T get(String endPoint, Class<T> responseClass) {
        return doRequest(endPoint, "GET", null, responseClass);
    }

    public <T> T post(String endPoint, Object body, Class<T> responseClass) {
        return doRequest(endPoint, "POST", body, responseClass);
    }

    public <T> T doRequest(String endpoint, String reqMethod, Object obj, Class<T> classType) {
        try{
            URL url = new URL(endpoint);
            Gson gson = new Gson();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(reqMethod); // GET or PUT
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", createBasicAuthHeaderValue("user", "password"));
//            conn.setRequestProperty("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
            Authenticator.setDefault(new BasicAuthenticator());
            conn.setAuthenticator(new BasicAuthenticator());
            conn.setDoOutput(true);

            if(obj != null) {
                String jsonInputString = gson.toJson(obj);
                try(OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            } else {
                conn.connect();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                String word = "";

                if(obj != null) {
                    try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))){
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        word = response.toString();
                    }
                } else {
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        word += scanner.nextLine();
                    }

                    //Close the scanner
                    scanner.close();
                }
//                WordData wordData = gson.fromJson(word, WordData.class);
                return gson.fromJson(word, classType);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createBasicAuthHeaderValue(String user, String password) {
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
//        String authHeaderValue = "Basic " + new String(encodedAuth);
        String authHeaderValue = "Basic dXNlcjpwYXNzd29yZA==";
        return authHeaderValue;
    }

    private final class BasicAuthenticator extends Authenticator {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("user", "password".toCharArray());
        }
    }
}
