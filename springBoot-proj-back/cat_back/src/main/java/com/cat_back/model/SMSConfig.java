package com.cat_back.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SMSConfig {
    private String accessKeyId;
    private String accessKeySecret;

    public SMSConfig() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("SMS.config");
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            if (inputStream == null) {
                throw new RuntimeException("SMS.config file not found in resources");
            }

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue; // 跳过空行和注释
                }

                String[] parts = line.split("=", 2);
                if (parts.length != 2) {
                    throw new RuntimeException("Invalid configuration format: " + line);
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "accessKeyId":
                        this.accessKeyId = value;
                        break;
                    case "accessKeySecret":
                        this.accessKeySecret = value;
                        break;
                    default:
                        throw new RuntimeException("Unknown configuration key: " + key);
                }
            }

            // 验证必须的配置项
            if (accessKeyId == null || accessKeySecret == null ) {
                throw new RuntimeException("Missing required configuration in SMS.config");
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load SMS configuration", e);
        }
    }

     public String getAccessKeyId() { return accessKeyId; }
     public String getAccessKeySecret() { return accessKeySecret; }
}