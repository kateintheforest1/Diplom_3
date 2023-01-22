package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.config.BurgersApi.LOGIN_PATH;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver, LOGIN_PATH);
    }

    @FindBy(xpath = ".//input[@name = 'name']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@type = 'password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement signInButton;

    @Step("Enter email")
    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Enter password")
    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Enter email and password")
    public void fillEmailAndPassword(String email, String password) {
        this.fillEmailInput(email);
        this.fillPasswordInput(password);
    }

    @Step("Sign in button click")
    public void signInButtonClick() {
        signInButton.click();
    }

    public void waitForSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signInButton));
    }
}

