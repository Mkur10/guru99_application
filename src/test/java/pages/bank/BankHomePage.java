package pages.bank;

import org.openqa.selenium.By;
import pages.BasePage;

public class BankHomePage extends BasePage {

    // Locator
    private By hereLink = By.xpath("//a[text()='here']");

    // Actions
    public void clickHereForRegistration() {
        click(hereLink);
    }
}
