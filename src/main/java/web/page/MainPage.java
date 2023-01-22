package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.config.BurgersApi.MAIN_PAGE_PATH;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver, MAIN_PAGE_PATH);
    }

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement signInButton;

    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement getOrderButton;

    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement personalAccount;

    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private WebElement currentTab;

    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunsTab;

    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement saucesTab;

    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement toppingTab;

    @Step("Sign in button click")
    public void signInButtonClick() {
        signInButton.click();
    }

    @Step("Account button click")
    public void accountButtonClick() {
        personalAccount.click();
    }

    @Step("Current tab name retrieve")
    public String getCurrentTabText() {
        return currentTab.getText();
    }

    @Step("Buns tab opened")
    public void bunsTabClick() {
        bunsTab.click();
    }

    @Step("Sauces tab opened")
    public void saucesTabClick() {
        saucesTab.click();
    }

    @Step("Toppings tab opened")
    public void toppingsTabClick() {
        toppingTab.click();
    }

    @Step("Get order button are shown")
    public boolean getOrderButtonIsDisplayed() {
        return getOrderButton.isDisplayed();
    }

    public void waitForSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signInButton));
    }

    public void waitForOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(getOrderButton));
    }
}

