package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.bank.BankHomePage;
import pages.bank.BankRegistrationPage;
import pages.bank.BankLoginPage;
import pages.bank.ManageHomePage;
import support.TestContext;

public class BankSteps {

    private TestContext testContext;
    private BankHomePage bankHomePage;
    private BankRegistrationPage bankRegistrationPage;
    private BankLoginPage bankLoginPage;
    private ManageHomePage manageHomePage;

    // Store generated credentials
    private String generatedUserId;
    private String generatedPassword;

    public BankSteps(TestContext context) {
        this.testContext = context;
        bankHomePage = new BankHomePage();
        bankRegistrationPage = new BankRegistrationPage();
        bankLoginPage = new BankLoginPage();
        manageHomePage = new ManageHomePage();
    }

    // Bank Registration
    @Given("User navigates to Bank Home Page")
    public void user_navigates_to_bank_home_page() {
        bankHomePage.goTo("https://demo.guru99.com/V1/index.php");
    }

    @When("User clicks on registration link")
    public void user_clicks_on_registration_link() {
        bankHomePage.clickHereForRegistration();
    }

    @And("User enters email {string}")
    public void user_enters_email(String email) {
        bankRegistrationPage.enterEmail(email);
    }

    @And("User submits registration")
    public void user_submits_registration() {
        bankRegistrationPage.clickSubmit();
    }

    @Then("User should get User ID and Password")
    public void user_should_get_user_id_and_password() {
        generatedUserId = bankRegistrationPage.getUserId();
        generatedPassword = bankRegistrationPage.getPassword();

        Assert.assertNotNull(generatedUserId, "User ID should not be null");
        Assert.assertNotNull(generatedPassword, "Password should not be null");

        System.out.println("Generated User ID: " + generatedUserId);
        System.out.println("Generated Password: " + generatedPassword);
    }

    // Bank Login
    @Given("User is on Bank Login Page")
    public void user_is_on_bank_login_page() {
        bankLoginPage.goTo("https://demo.guru99.com/V1/index.php");
    }

    @When("User logs in with generated credentials")
    public void user_logs_in_with_generated_credentials() {
        bankLoginPage.login(generatedUserId, generatedPassword);
    }

    // Post-Login
    @Then("User should see welcome message containing {string}")
    public void user_should_see_welcome_message(String expectedText) {
        String actualMessage = manageHomePage.getWelcomeMessage();
        Assert.assertTrue(actualMessage.contains(expectedText),
                "Expected welcome message to contain: " + expectedText);
    }

    @And("User logs out")
    public void user_logs_out() {
        manageHomePage.clickLogout();
    }
}
