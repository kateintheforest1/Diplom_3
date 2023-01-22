package page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import web.page.LoginPage;
import web.page.MainPage;
import web.page.ProfilePage;

public class ProfilePageTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    ProfilePage profilePage;

    @Before
    public void start() {
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        driver.get(loginPage.getPageUrl());
        loginPage.waitForSignInButton();

        loginPage.fillEmailAndPassword(super.email, super.password);
        loginPage.signInButtonClick();

        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        mainPage.waitForOrderButton();

        mainPage.accountButtonClick();
        profilePage = new ProfilePage(driver);
        PageFactory.initElements(driver, profilePage);
        profilePage.waitForProfileLink();
    }

    @Test
    @DisplayName("Go to personal account from main page")
    public void clickPersonalAccountButtonToProfilePageTest() {
        Assert.assertEquals(profilePage.getPageUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Got to constructor from personal page")
    public void clickConstructorRedirectedToMainPageTest() {
        profilePage.clickConstructor();
        mainPage.waitForOrderButton();

        Assert.assertEquals(mainPage.getPageUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Log out via personal page button")
    public void clickLogOutButtonLogOutTest() {
        profilePage.logoutButtonClick();
        loginPage.waitForSignInButton();

        Assert.assertEquals(loginPage.getPageUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Go to main page via logo click")
    public void clickLogoRedirectedToMainPageTest() {
        profilePage.logoClick();
        mainPage.waitForOrderButton();

        Assert.assertEquals(mainPage.getPageUrl(), driver.getCurrentUrl());
    }
}

