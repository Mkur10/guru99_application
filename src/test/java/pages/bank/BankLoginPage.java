package pages.bank;

import org.openqa.selenium.By;
import pages.BasePage;

public class BankLoginPage extends BasePage {

    // Locators
    private By userIdField = By.xpath("//input[@type='text']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//input[@type='submit']");

    // Actions
    public void enterUserId(String userId) {
        type(userIdField, userId);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    // Combined action
    public void login(String userId, String password) {
        enterUserId(userId);
        enterPassword(password);
        clickLogin();
    }
}
