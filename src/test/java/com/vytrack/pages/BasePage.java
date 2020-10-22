package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(className = "oro-subtitle")
    protected WebElement pageSubtitle;


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getPageSubTitleText(){
        return pageSubtitle.getText();
    }
    public void navigateTo(String tab, String module){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        String tabXpath = "//*[contains(text(),'"+tab+"') and @class='title title-level-1']"; // instead of dashboard we put tab because it's changing all the time
        String moduleXpath = "//*[contains(text(),'"+module+"') and @class='title title-level-2']";
        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));

        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();
    }
}