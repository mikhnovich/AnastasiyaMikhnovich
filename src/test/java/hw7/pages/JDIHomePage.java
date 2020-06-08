package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.components.JDILoginForm;
import hw7.domain.User;

public class JDIHomePage extends WebPage {

    @XPath("//*[@id='user-icon']")
    private Button userIcon;

    @Css("#user-name")
    private Text displayedName;

    @XPath("//a[text()='Metals & Colors']")
    private Button metalsAndColors;

    private JDILoginForm jdiLoginForm;

    public Text getDisplayedName() {
        return displayedName;
    }

    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public void openMetalsAndColors() {
        metalsAndColors.click();
    }
}
