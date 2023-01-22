package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.config.BurgersApi.BASE_URL;

public class BasePage {

    WebDriver driver;

    protected String pageUrl;

    public BasePage(WebDriver driver, String pagePath) {
        this.driver = driver;
        this.pageUrl = BASE_URL + pagePath;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    @FindBy(xpath = ".//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement stellarBurgersLogo;

    @FindBy(xpath = ".//a[text() = 'Войти']")
    private WebElement signInLink;

    @Step("Logo click")
    public void logoClick() {
        stellarBurgersLogo.click();
    }

    @Step("Sign in button click")
    public void signInLinkClick() {
        signInLink.click();
    }
}
