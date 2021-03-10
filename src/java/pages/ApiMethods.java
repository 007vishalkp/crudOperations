package pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ApiMethods {
    private int user_quiz_id = 0;
    private String authBearerToken = "";

    public void getMethodCall(String api) throws IOException {
        URL url = new URL(api);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (authBearerToken != null) {
            con.setRequestProperty("Authorization", "Bearer " + authBearerToken);
        }

        int responseCode = con.getResponseCode();
        String responseMessage = con.getResponseMessage();
        String responseMethod = con.getRequestMethod();

        System.out.println("GET Response Code = " + responseCode);
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
            if (api.contains("is_from_classroom")) {
                System.out.println("Response-->" + response.toString());
            }
        } else {
            System.out.println("GET request not worked--> " + "GET Response Message = " + responseMessage + ", GET Response Method = " + responseMethod);
        }
    }

    public void postMethodCall(String api, String jsonStr) throws IOException {
        URL obj = new URL(api);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
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

        int responseCode = con.getResponseCode();
        String responseMessage = con.getResponseMessage();
        String responseMethod = con.getRequestMethod();
        System.out.println("POST Response Code = " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder responseBuffer = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
            // print result
//            System.out.println("Response--> " + responseBuffer.toString());
            if (api.contains("signup") || api.contains("login")) {
                setAuthBearerToken(responseBuffer.toString());
            }
            if (api.contains("user_quiz")) {
                setUserQuizId(responseBuffer.toString());
            }
        } else {
            System.out.println("POST request not worked--> " + "POST Response Message = " + responseMessage + ", POST Response Method = " + responseMethod);
        }
    }

    public void patchMethodCall(String api, String jsonStr) throws IOException {
        URL obj = new URL(api);
//        System.out.println("This is the auth token:--> " + authBearerToken);
        allowMethods("PATCH");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
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

        int responseCode = con.getResponseCode();
        String responseMessage = con.getResponseMessage();
        String responseMethod = con.getRequestMethod();
        System.out.println("PATCH Response Code = " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
//            System.out.println("Response--> " + response.toString());
        } else {
            System.out.println("PATCH request not worked--> " + "PATCH Response Message = " + responseMessage + ", PATCH Response Method = " + responseMethod);
        }
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

    public int getUserQuizId() {
        return user_quiz_id;
    }

    private void setUserQuizId(String response) {
        int a = response.indexOf("user_quiz");
        int b = response.indexOf("submitted_sections");
        String test = response.substring(a, b);
        test = test.replaceAll("\"", "");
        a = test.indexOf("id");
        b = test.indexOf("status");
        test = test.substring(a, b);
        test = test.replaceAll("[^0-9]", "");

        user_quiz_id = Integer.parseInt(test);
    }

    public String getAuthBearerToken() {
        return authBearerToken;
    }

    private void setAuthBearerToken(String response) {
        int a = response.indexOf("token");
        int b = response.indexOf("url_token");
        String test = response.substring(a, b - 2);
        test = test.replaceAll("\"", "");
        test = test.replaceAll("token:", "");

        authBearerToken = test;
    }

    public void getAllProducts() throws IOException {
        getMethodCall("https://api.learnyst.com/learner/v10/courses?is_from_classroom=true&school_id=23698&device_type=4&is_id=true");//To check if enrolled or not
    }
}
