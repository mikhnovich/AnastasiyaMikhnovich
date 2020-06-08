package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.JDIHomePage;
import hw7.pages.JDIMetalsColorsPage;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JDISite {
    @Url("/index.html")
    @Title("HomePage")
    public static JDIHomePage jdiHomePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static JDIMetalsColorsPage jdiMetalsColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

}
