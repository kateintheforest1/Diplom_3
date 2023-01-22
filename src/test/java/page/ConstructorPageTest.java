package page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import web.page.MainPage;

public class ConstructorPageTest extends BaseTest {
    MainPage mainPage;

    @Before
    public void start() {
        mainPage = new MainPage(driver);

        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getPageUrl());
        mainPage.waitForSignInButton();
    }

    @Test
    @DisplayName("Buns tap opened")
    public void switchToBunsTabTest() {
        mainPage.toppingsTabClick();
        mainPage.bunsTabClick();

        Assert.assertEquals("Булки", mainPage.getCurrentTabText());
    }

    @Test
    @DisplayName("Sauces tab opened")
    public void switchToSaucesTabTest() {
        mainPage.saucesTabClick();

        Assert.assertEquals("Соусы", mainPage.getCurrentTabText());
    }

    @Test
    @DisplayName("Toppings tab opened")
    public void switchToToppingsTabTest() {
        mainPage.toppingsTabClick();

        Assert.assertEquals("Начинки", mainPage.getCurrentTabText());
    }
}
