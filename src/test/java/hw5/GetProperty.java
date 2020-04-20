package hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {
    private static final String PATH = "src/test/resources/config.properties";

    private FileInputStream file;
    private Properties property = new Properties();

    public String getProperty(String propertyName) throws IOException {
        file = new FileInputStream(PATH);
        property.load(file);
        return (String) property.get(propertyName);
    }
}
