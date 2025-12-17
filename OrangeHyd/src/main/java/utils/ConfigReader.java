package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadConfig() {
        try {
            // Load config.properties from src/test/resources via classpath
            InputStream fis = ConfigReader.class.getClassLoader()
                    .getResourceAsStream("config.properties");

            if (fis == null) {
                throw new RuntimeException("config.properties not found in src/test/resources");
            }

            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        if (prop == null) {
            loadConfig();
        }
        return prop.getProperty(key);
    }
}
