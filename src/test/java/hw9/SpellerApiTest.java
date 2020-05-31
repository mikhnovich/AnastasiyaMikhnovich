package hw9;

import hw9.dto.SpellerData;
import hw9.dto.SpellerSuggestion;
import hw9.service.SpellerActions;
import hw9.service.SpellerDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SpellerApiTest {

    private SpellerActions spellerActions;

    @BeforeClass
    public void precondition() {
        spellerActions = new SpellerActions();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "noCorrectionsRequiredProvider")
    public void noCorrectionsRequiredTest(SpellerData spellerData) throws IOException {

        SpellerSuggestion[] result = spellerActions.checkText(spellerData);

        new SpellerFluentAssertions(result)
                .verifyEmptyResponse();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "correctDataWithUrlsProvider")
    public void correctDataWithUrlsTest(SpellerData spellerData) throws IOException {

        SpellerSuggestion[] result = spellerActions.checkText(spellerData);

        new SpellerFluentAssertions(result)
                .verifyEmptyResponse();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "oneErrorPerLineDataProvider")
    public void oneErrorPerLineDataTest(SpellerData spellerData) throws IOException {
        SpellerSuggestion[] result = spellerActions.checkText(spellerData);
        new SpellerFluentAssertions(result)
                .verifyNotEmptyResponse()
                .verifyCode(spellerData.getCodes())
                .verifyPos(spellerData.getPos())
                .verifyRow(spellerData.getRows())
                .verifyCol(spellerData.getCols())
                .verifyLen(spellerData.getLen())
                .verifyWords(spellerData.getWords())
                .verifySuggestion(spellerData.getSuggestions());
    }
}
