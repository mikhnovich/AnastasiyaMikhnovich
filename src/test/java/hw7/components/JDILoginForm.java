package hw7.components;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import hw7.domain.User;

import java.awt.*;

public class JDILoginForm extends Form<User> {
    @XPath("//*[@id='name']")
    private TextField name;

    @XPath("//*[@id='password']")
    private TextField password;

    @XPath("//*[@id='login-button']")
    private Button loginButton;

}
