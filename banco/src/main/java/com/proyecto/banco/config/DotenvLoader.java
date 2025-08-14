package com.proyecto.banco.config;
import java.util.Map;
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {
    public static void loadEnv() {
        Dotenv dotenv = Dotenv.configure()
                              .filename(".env")
                              .ignoreIfMalformed()
                              .ignoreIfMissing()
                              .load();

        dotenv.entries().forEach(entry -> {
            Map<String, String> env = System.getenv();
            if (!env.containsKey(entry.getKey())) {
                System.setProperty(entry.getKey(), entry.getValue());
            }
        });
    }
}
