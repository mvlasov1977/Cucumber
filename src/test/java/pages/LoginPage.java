package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.WaitersUtil;

public class LoginPage {
    private final Long waiter = 5L; // seconds
    private final String pageName = "Login Page";
    private final String pageSign = "//h2";
    private boolean pageSuccess = false;
    private By usernameInputField = By.id("username");
    private By passwordInputField = By.id("password");
    private By loginButton = By.xpath("//*[@class=\"radius\"]");
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;

        WaitersUtil.explicitWait(driver, By.xpath(pageSign), waiter);
        if ( !driver.findElement(By.xpath(pageSign)).getText().equals(pageName)){
            throw new IllegalStateException("Wrong page ! Expected -> " + pageName);
        }else{
            pageSuccess = true;
        }
    }
    public boolean isPageSuccess() {
        return pageSuccess;
    }
    public LoginPage enterUserName(String userName){
        driver.findElement(usernameInputField).sendKeys(userName);
        return this;
    }
    public LoginPage enterPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }
    public WebDriver onClickButton(){
        driver.findElement(loginButton).click();
        return driver;
    }

}
