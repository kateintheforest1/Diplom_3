package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static web.config.BurgersApi.REGISTER_PAGE_PATH;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver, REGISTER_PAGE_PATH);
    }

    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInput;

    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInput;

    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement signUpButton;

    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordError;

    @Step("Name filled")
    public void fillNameInput(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Email filled")
    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Password filled")
    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("All required fields filled")
    public void fillAllTheFields(String name, String email, String password) {
        this.fillNameInput(name);
        this.fillEmailInput(email);
        this.fillPasswordInput(password);
    }

    @Step("Sign up page opened")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Incorrect password response retrieved")
    public String getIncorrectPasswordErrorText() {
        return incorrectPasswordError.getText();
    }

    public void waitForSignUpButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(signUpButton));
    }

    public void waitForIncorrectPasswordError() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(incorrectPasswordError));
    }
}