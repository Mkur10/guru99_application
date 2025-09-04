package pages.bank;

import org.openqa.selenium.By;
import pages.BasePage;

public class BankRegistrationPage extends BasePage {

    // Locators
    private By emailInput = By.name("emailid");    // Email input field
    private By submitButton = By.name("btnLogin"); // Submit button

    private By userId = By.xpath("//tr//td[text()='User ID :']//following-sibling::td");
    private By password = By.xpath("//tr//td[text()='Password :']//following-sibling::td");

    // Actions
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public String getUserId() {
        return getText(userId);
    }

    public String getPassword() {
        return getText(password);
    }
}
