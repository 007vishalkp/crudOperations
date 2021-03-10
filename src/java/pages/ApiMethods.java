package pages;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


public class ApiMethods {
    private int user_quiz_id = 0;
    private String authBearerToken = "";

    public int getMethodCall(String api) throws IOException {
        int responseCode;
        String responseMessage = "", responseMethod = "";
        URL url = new URL(api);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (authBearerToken != null) {
            con.setRequestProperty("Authorization", "Bearer " + authBearerToken);
        }

        responseCode = con.getResponseCode();
        responseMessage = con.getResponseMessage();
        responseMethod = con.getRequestMethod();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println("GET Response Code = " + responseCode);
            System.out.println("GET Response message = " + responseMessage);
            System.out.println("Response-->" + response.toString());
        } else {
            System.out.println("GET request failed-->" + responseCode + "GET Response Message = " + responseMessage + ", GET Response Method = " + responseMethod);
        }
        return responseCode;
    }

    public int postMethodCall(String api, String jsonStr) throws IOException {
        int responseCode;
        String responseMessage = "", responseMethod = "";
        URL url = new URL(api);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        if (authBearerToken != null) {
            con.setRequestProperty("Authorization", "Bearer " + authBearerToken);
        }

        // For POST only - START
        con.setDoOutput(true);
        byte[] out = jsonStr.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        con.setFixedLengthStreamingMode(length);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.connect();
        try (OutputStream os = con.getOutputStream()) {
            os.write(out);
        }
        // For POST only - END

        responseCode = con.getResponseCode();
        responseMessage = con.getResponseMessage();
        responseMethod = con.getRequestMethod();

        if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder responseBuffer = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
            // print result
            System.out.println("POST Response Code: " + responseCode);
            System.out.println("POST Response--> " + responseBuffer.toString());
        } else {
            System.out.println("POST request not worked--> " + "POST Response Message = " + responseMessage + ", POST Response Method = " + responseMethod);
        }
        return responseCode;
    }

    public int patchMethodCall(String api, String jsonStr) throws IOException {
        int responseCode;
        String responseMessage = "", responseMethod = "";
        URL url = new URL(api);
        allowMethods("PATCH");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PATCH");
        con.setRequestProperty("Authorization", "Bearer " + authBearerToken);

        // For POST only - START
        con.setDoOutput(true);
        byte[] out = jsonStr.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        con.setFixedLengthStreamingMode(length);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.connect();
        try (OutputStream os = con.getOutputStream()) {
            os.write(out);
        }
        // For POST only - END

        responseCode = con.getResponseCode();
        responseMessage = con.getResponseMessage();
        responseMethod = con.getRequestMethod();
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("PATCH Response Code = " + responseCode);
            System.out.println("PATCH Response--> " + response.toString());
        } else {
            System.out.println("PATCH request not worked--> " + "PATCH Response Message = " + responseMessage + ", PATCH Response Method = " + responseMethod);
        }
        return responseCode;
    }

    private void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);
            methodsField.setAccessible(true);
            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);
            methodsField.set(null/*static field*/, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public int putMethodCall(String api, String jsonStr) throws IOException {
        int responseCode;
        String responseMessage = "", responseMethod = "";
        URL url = new URL(api);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write(jsonStr);
        out.close();

        responseCode = httpCon.getResponseCode();
        responseMessage = httpCon.getResponseMessage();
        responseMethod = httpCon.getRequestMethod();
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    httpCon.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("PUT Response--> " + response.toString());
            System.out.println("PUT Response code--> " + httpCon.getResponseCode());
        } else {
            System.out.println("PUT request not worked--> " + "PUT Response Message = " + responseMessage + ", PUT Response Method = " + responseMethod);
        }
        return responseCode;
    }

    public int deleteMethodCall(String api) throws IOException {
        int responseCode;
        String responseMessage = "", responseMethod = "";
        URL url = new URL(api);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty(
                "Content-Type", "application/x-www-form-urlencoded");
        httpCon.setRequestMethod("DELETE");
        httpCon.connect();
        RequestSpecification request = RestAssured.given();
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");
        // Delete the request and check the response
        responseCode = httpCon.getResponseCode();
        responseMessage = httpCon.getResponseMessage();
        responseMethod = httpCon.getRequestMethod();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("DELETE request not worked--> " + "DELETE Response Message = " + responseMessage + ", DELETE Response Method = " + responseMethod);
        }
        return responseCode;
    }
}
