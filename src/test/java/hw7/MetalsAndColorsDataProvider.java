package hw7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.domain.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class MetalsAndColorsDataProvider {
    @DataProvider
    public Object[][] testData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("JDI_ex8_metalsColorsDataSet.json");
        Map<String, MetalsAndColorsData> formData = objectMapper.readValue(is,
                new TypeReference<LinkedHashMap<String, MetalsAndColorsData>>() {
                });
        Object[][] testData = new Object[formData.size()][1];
        int i = 0;
        for (MetalsAndColorsData value : formData.values()) {
            testData[i][0] = value;
            i++;
        }
        return testData;
    }
}
