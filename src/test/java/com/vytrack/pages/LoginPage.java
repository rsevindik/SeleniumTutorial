package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="prependedInput")
    private WebElement username;

    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;

    @FindBy(id="prependedInput2")
    private WebElement password;

    public String getWarningMessageText(){   // we need to implement wait time here to secure locator finding element within certain wait time.!!
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){

       String usernameValue = ConfigurationReader.getProperty("storemanager.username"); // command and hover over then see the value
       String passwordValue = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
    public void login(String role){
        String usernameValue = ""; // command and hover over then see the value
        String passwordValue = ConfigurationReader.getProperty("password");
        if(role.equalsIgnoreCase("sales manager")){
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        }else if(role.equalsIgnoreCase("driver")){
            usernameValue = ConfigurationReader.getProperty("driver.username");
        }else{
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

}
