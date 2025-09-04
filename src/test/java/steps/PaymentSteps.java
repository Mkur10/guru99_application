package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.payment.PurchasePage;
import pages.payment.PaymentPage;
import pages.payment.PaymentsuccessPage;
import pages.payment.GenerateCardPage;

public class PaymentSteps {

    private PurchasePage purchasePage = new PurchasePage();
    private PaymentPage paymentPage = new PaymentPage();
    private PaymentsuccessPage paymentSuccessPage = new PaymentsuccessPage();
    private GenerateCardPage generateCardPage = new GenerateCardPage();

    private String cardNumber;
    private String cvv;
    private String expDate;

    // Purchase
    @Given("User navigates to Purchase Page")
    public void user_navigates_to_purchase_page() {
        purchasePage.goTo("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @When("User selects quantity {string} and clicks Buy Now")
    public void user_selects_quantity_and_clicks_buy_now(String quantity) {
        purchasePage.selectQuantity(quantity);
        purchasePage.clickBuyNow();
    }

    //Generate Card
    @And("User generates a new card")
    public void user_generates_a_new_card() {
        generateCardPage.goTo("https://demo.guru99.com/payment-gateway/cardnumber.php");
        cardNumber = generateCardPage.getCardNumber();
        cvv = generateCardPage.getCVV();
        expDate = generateCardPage.getExpDate();
    }

    //  Payment
    @And("User enters card details and makes payment")
    public void user_enters_card_details_and_makes_payment() {
        paymentPage.goTo("https://demo.guru99.com/payment-gateway/process_purchasetoy.php");

        String[] expParts = expDate.split("/");
        String month = expParts[0].trim();
        String year = expParts[1].trim();

        paymentPage.makePayment(cardNumber, month, year, cvv);
    }

    // Success Page
    @Then("User should see payment success message {string}")
    public void user_should_see_payment_success_message(String expectedMessage) {
        String actualMessage = paymentSuccessPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("User should see an Order ID")
    public void user_should_see_an_order_id() {
        String orderId = paymentSuccessPage.getOrderId();
        Assert.assertTrue(orderId.matches("\\d+"), "Order ID should be numeric");
        System.out.println("Generated Order ID: " + orderId);
    }
}
