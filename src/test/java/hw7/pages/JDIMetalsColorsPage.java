package hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.components.JDIMetalsAndColorsForm;
import hw7.domain.MetalsAndColorsData;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class JDIMetalsColorsPage extends WebPage {

    private JDIMetalsAndColorsForm jdiMetalsAndColorsForm;

    @Css("#submit-button")
    private Button submitBtn;

    @Css(".results li")
    private UIElement results;

    public void submitForm(MetalsAndColorsData data) {
        jdiMetalsAndColorsForm.fillFormWithValues(data);
        submitBtn.click();
    }

    public List<String> getResults() {
        return results.getAll()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
