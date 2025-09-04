package pages.payment;

import org.openqa.selenium.By;
import pages.BasePage;

public class GenerateCardPage extends BasePage {

    // Locators
    private By cardNumber = By.xpath("//h4[starts-with(text(),'Card Number')]");
    private By cvv = By.xpath("//h4[starts-with(text(),'CVV')]");
    private By expDate = By.xpath("//h4[starts-with(text(),'Exp')]");
    private By creditLimit = By.xpath("//h4[starts-with(text(),'Credit Limit')]");

    // Actions
    public String getCardNumber() {
        return getText(cardNumber).replace("Card Number:-", "").trim();
    }

    public String getCVV() {
        return getText(cvv).replace("CVV:-", "").trim();
    }

    public String getExpDate() {
        return getText(expDate).replace("Exp:-", "").trim();
    }

    public String getCreditLimit() {
        return getText(creditLimit).replace("Credit Limit", "").trim();
    }
}
