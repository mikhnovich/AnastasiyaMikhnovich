package hw9.service;

import hw9.dto.SpellerData;
import hw9.parser.JsonFileParser;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SpellerDataProvider {

    public static final String NO_CORRECTIONS_REQ_JSON = "src/test/resources/HW9/no_corrections_req.json";
    public static final String CORRECT_DATA_WITH_URLS_JSON = "src/test/resources/HW9/correct_data_with_urls.json";
    public static final String ONE_ERROR_PER_LINE_DATA_JSON = "src/test/resources/HW9/one_error_per_line_data.json";

    @DataProvider
    public Iterator<Object[]> noCorrectionsRequiredProvider() {
        return getIterator(NO_CORRECTIONS_REQ_JSON);
    }

    @DataProvider
    public Iterator<Object[]> correctDataWithUrlsProvider() {
        return getIterator(CORRECT_DATA_WITH_URLS_JSON);
    }

    @DataProvider
    public Iterator<Object[]> oneErrorPerLineDataProvider() {
        return getIterator(ONE_ERROR_PER_LINE_DATA_JSON);
    }

    private Iterator<Object[]> getIterator(String path) {
        List<SpellerData> testData = JsonFileParser.parseFile(path);
        Collection<Object[]> data = new ArrayList<>();
        if (testData != null) {
            testData.forEach(item -> data.add(new Object[]{item}));
        }
        return data.iterator();
    }

}
