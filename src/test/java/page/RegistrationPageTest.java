package page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import web.page.LoginPage;
import web.page.RegistrationPage;

import static generator.UserdataGenerator.randomEmail;
import static generator.UserdataGenerator.randomPassword;

public class RegistrationPageTest extends BaseTest {

    RegistrationPage registrationPage;

    private final String name = "Kate";
    private String email, password;

    @Before
    public void start() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getPageUrl());
        registrationPage.waitForSignUpButton();

        email = randomEmail();
    }

    @Test
    @DisplayName("User successfully created")
    public void createUserSuccessfullyTest() {
        password = randomPassword();

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();

        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();

        Assert.assertEquals(loginPage.getPageUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Got error with password less than six characters")
    public void createUserWithIncorrectPasswordTest() {
        password = "short";

        registrationPage.fillAllTheFields(name, email, password);
        registrationPage.clickSignUpButton();
        registrationPage.waitForIncorrectPasswordError();

        Assert.assertEquals("Некорректный пароль", registrationPage.getIncorrectPasswordErrorText());
    }
}

