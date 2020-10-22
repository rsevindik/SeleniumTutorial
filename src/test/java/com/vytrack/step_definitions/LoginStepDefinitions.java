package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    // WebDriver driver;  no need anymore.!!
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa1.vytrack.com");*/
        Driver.getDriver().get("http://qa1.vytrack.com");
    }
    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
//        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager110");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        loginPage.login();
        Thread.sleep(3000);
    }
    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText().trim(); //driver.findElement(By.className("oro-subtitle")).getText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual); // in JUnit message comes first before the comparison
        System.out.println("I see the Dashboard page!");
        //driver.quit();
        Driver.closeDriver();
    }
    //When user logs in as a "driver"
    //When user logs in as a "sales manager"
    //When user logs in as a "store manager"
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string){
        loginPage.login(string);
    }

    //"storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) { // rename the variable name from string to ... suchh as expected error message
        String actualResult = loginPage.getWarningMessageText();
Assert.assertEquals(expected,actualResult);
    }

}
