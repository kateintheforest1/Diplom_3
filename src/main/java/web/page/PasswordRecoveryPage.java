package web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.config.BurgersApi.FORGOT_PASSWORD_PAGE_PATH;

public class PasswordRecoveryPage extends BasePage {

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver, FORGOT_PASSWORD_PAGE_PATH);
    }

    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement restorePasswordButton;

    public void waitForRestorePasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(restorePasswordButton));
    }
}

