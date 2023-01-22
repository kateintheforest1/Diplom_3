package page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import web.page.LoginPage;
import web.page.MainPage;
import web.page.PasswordRecoveryPage;
import web.page.RegistrationPage;

public class LoginPageTest extends BaseTest {

    MainPage mainPage;
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;
    LoginPage loginPage;

    @After
    public void end() {
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.waitForSignInButton();
        loginPage.fillEmailAndPassword(super.email, super.password);
        loginPage.signInButtonClick();
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();
        Assert.assertTrue(mainPage.getOrderButtonIsDisplayed());
    }

    @Test
    @DisplayName("Sign in via login button")
    public void clickLogInOnMainPageTest() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getPageUrl());

        mainPage.waitForSignInButton();
        mainPage.signInButtonClick();
    }

    @Test
    @DisplayName("Sign in via personal account button")
    public void clickPersonalAccountButtonOnMainPageTest() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getPageUrl());

        mainPage.waitForSignInButton();
        mainPage.accountButtonClick();
    }

    @Test
    @DisplayName("Sign in via registration form button")
    public void clickSignInLinkOnRegistrationPageTest() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        driver.get(registrationPage.getPageUrl());

        registrationPage.waitForSignUpButton();
        registrationPage.signInLinkClick();
    }

    @Test
    @DisplayName("Sign in via password recovery form button")
    public void clickSignInLinkOnPasswordRecoveryPageTest() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        PageFactory.initElements(driver, passwordRecoveryPage);
        driver.get(passwordRecoveryPage.getPageUrl());

        passwordRecoveryPage.waitForRestorePasswordButton();
        passwordRecoveryPage.signInLinkClick();
    }
}
