package pages.payment;

import org.openqa.selenium.By;
import pages.BasePage;

public class PaymentsuccessPage extends BasePage {

    // Locators
    private By successMessage = By.xpath("//h2[contains(text(),'Payment successfull!')]");
    private By orderId = By.xpath("//strong[text()='Order ID']//parent::h3//parent::td//following-sibling::td");
    private By homeButton = By.xpath("//a[text()='Home']");

    // Actions
    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getOrderId() {
        return getText(orderId);
    }

    public void clickHome() {
        click(homeButton);
    }
}