package pages.payment;

import org.openqa.selenium.By;
import pages.BasePage;

public class PaymentPage extends BasePage {

    // Locators
    private By cardNumberField = By.xpath("//div//input[@type='text' and @id='card_nmuber']");
    private By monthDropdown = By.xpath("//select[@name='month']");
    private By yearDropdown = By.xpath("//select[@name='year']");
    private By cvvField = By.xpath("//input[@type='text' and @id='cvv_code']");
    private By payButton = By.xpath("//input[@type='submit']");

    // Actions
    public void enterCardNumber(String cardNumber) {
        type(cardNumberField, cardNumber);
    }

    public void selectMonth(String month) {
        selectDropdownByValue(monthDropdown, month);
    }

    public void selectYear(String year) {
        selectDropdownByValue(yearDropdown, year);
    }

    public void enterCVV(String cvv) {
        type(cvvField, cvv);
    }

    public void clickPay() {
        click(payButton);
    }

    // Combined action
    public void makePayment(String cardNumber, String month, String year, String cvv) {
        enterCardNumber(cardNumber);
        selectMonth(month);
        selectYear(year);
        enterCVV(cvv);
        clickPay();
    }
}