package definitions;

import org.example.LoginPage;
import org.example.MainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginTestDefinition {
    private final String url = "https://the-internet.herokuapp.com/login";
    private LoginPage myLoginPage ;
    private MainPage myMainPage;
    private ChromeDriver driver;
    @Before
    public void initDriver(){
        ChromeDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.get(url);
        driver.manage().deleteAllCookies();
    }
    @Given("^I open login page$")
    public void openLoginPage(){
        myLoginPage = new LoginPage(driver);
    }
    @When("I enter my {string} login on the Login Page")
    public void enterLogin(String myLogin){
        myLoginPage.enterUserName(myLogin);
    }
    @When("I enter my {string} password on the Login Page")
    public void enterPassword(String myPassword){
        myLoginPage.enterPassword(myPassword);
    }
    @When("I click on submit button on the Login Page")
    public void onButtonClick(){
        myLoginPage.onClickButton();
    }
    @Then("The main page is displayed")
    public void showMainPage(){
        myMainPage = new MainPage(driver);
        Assertions.assertTrue(myMainPage.isPageSuccess());
    }
    @Then("I see alarm {string}")
    public void checkAlarmMessage(String myMessage){
        if (!myLoginPage.getAlarmMessage().contains(myMessage)){
            throw new IllegalStateException("Wrong response ! Expected -> " + myMessage);
        }
    }
    @After
    public void closeDriver(){
        driver.close();
    }

}
