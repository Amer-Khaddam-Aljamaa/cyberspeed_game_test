package com.cyberspeed.game;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class cyberspeed_game_test {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = CyberspeedGameTest.class.getClassLoader().getResourceAsStream("application.yml")) {
            Map<String, Object> config = yaml.load(inputStream);

            // Access values
            String activeClient = (String) config.get("active_client");
            Map<String, Object> serverConfig = (Map<String, Object>) config.get("server");
            int port = (int) serverConfig.get("port");

            System.out.println("Active Client: " + activeClient);
            System.out.println("Server Port: " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
