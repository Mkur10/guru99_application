package pages.bank;

import org.openqa.selenium.By;
import pages.BasePage;

public class ManageHomePage extends BasePage {

    // Locators
    private By welcomeMessage = By.xpath("//td//marquee"); // example
    private By logoutButton = By.xpath("//a[text()='Log out']");

    // Actions
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

    public void clickLogout() {
        click(logoutButton);
    }
}
