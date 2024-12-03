package com.saucedemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class Config {

    private static String baseUrl;
    private static String browser;
    private static String hubUrl;
    private static String email;
    private static String password;

    static {
        try (FileReader reader = new FileReader("resources/config.json")) {
            Gson gson = new Gson();
            JsonObject config = gson.fromJson(reader, JsonObject.class);

            
            baseUrl = config.get("baseUrl").getAsString();
            browser = config.get("browser").getAsString();
            hubUrl = config.get("hubUrl").getAsString();
            email = config.get("email").getAsString();
            password = config.get("password").getAsString();

        } catch (IOException e) {
            System.err.println("Error reading config file: " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Error: Missing required fields in the config file.");
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getHubUrl() {
        return hubUrl;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
