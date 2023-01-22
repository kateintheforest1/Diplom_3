package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.config.BurgersApi.PROFILE_PAGE_PATH;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver, PROFILE_PAGE_PATH);
    }

    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement constructor;

    @FindBy(xpath = ".//a[text() = 'Профиль']")
    private WebElement profileLink;

    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement logoutButton;

    @Step("New order")
    public void clickConstructor() {
        constructor.click();
    }

    @Step("Log out")
    public void logoutButtonClick() {
        logoutButton.click();
    }

    public void waitForProfileLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(profileLink));
    }
}

