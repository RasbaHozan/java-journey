package com.saucedemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class DataProvider {

    @Test
    public void testLogin() {
        try {
            JsonObject credentials = getLoginCredentials();

            String email = credentials.get("email").getAsString();
            String password = credentials.get("password").getAsString();

            System.out.println("Testing login with email: " + email + " and password: " + password);
            assert email != null && password != null;

        } catch (IOException e) {
            System.err.println("Error reading credentials from JSON file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Error: Missing required fields in the credentials data.");
        }
    }

    private JsonObject getLoginCredentials() throws IOException {
        try (FileReader reader = new FileReader("resources/data.json")) {
            Gson gson = new Gson();
            JsonObject data = gson.fromJson(reader, JsonObject.class);

            return data.getAsJsonObject("loginCredential1");
        }
    }
}
