package WeatherRequest.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    Properties properties;

    protected BaseTest(){
        properties = new Properties();
        String propertiesFileName = System.getProperty("PROPERTIES_FILE");
        if (propertiesFileName == null) {
            propertiesFileName = "app.properties";
        }
        try (InputStream in = BaseTest.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            properties.load(in);
        } catch (IOException e) {
            throw new AssertionError("Test run blocked. Cannot read properties: " + propertiesFileName, e);
        }
    }
}
