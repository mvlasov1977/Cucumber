package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final Long waiter = 5L; // seconds
    private final String pageName = "Secure Area";
    private final String pageSign = "//h2";
    private boolean pageSuccess = false;
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;

        WaitersUtil.explicitWait(driver, By.xpath(pageSign), waiter);
        if ( !driver.findElement(By.xpath(pageSign)).getText().equals(pageName) ) {
            throw new IllegalStateException("Wrong page ! Expected -> " + pageName);
        }else{
            pageSuccess = true;
        }
    }
    public boolean isPageSuccess(){
        return pageSuccess;
    }
    public void clearDriver(){
        driver.quit();
    }
}
