package pages.payment;

import org.openqa.selenium.By;
import pages.BasePage;

public class PurchasePage extends BasePage {

    // Locators
    private By quantityDropdown = By.xpath("//select[@name='quantity']");
    private By buyNowButton = By.xpath("//input[@value='Buy Now']");

    // Actions
    public void selectQuantity(String quantity) {
        selectDropdownByValue(quantityDropdown, quantity);
    }

    public void clickBuyNow() {
        click(buyNowButton);
    }
}