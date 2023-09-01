package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginTestDefinition {
    private String url = "https://the-internet.herokuapp.com/login";
    private LoginPage myLoginPage ;
    private MainPage myMainPage;
    @Given("I open login page")
    public void openLoginPage(){
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        chromeDriver.manage().deleteAllCookies();
        myLoginPage = new LoginPage(chromeDriver);
        //Assertions.assertTrue(myLoginPage.isPageSuccess());
        throw new io.cucumber.java.PendingException();
    }
    @When("I enter my {string} login password on the Login Page")
    public void enterLogin(String myLogin){
        myLoginPage.enterUserName(myLogin);
        throw new io.cucumber.java.PendingException();
    }
    @When("I enter my {string} password on the Login Page")
    public void enterPassword(String myPassword){

        myLoginPage.enterPassword(myPassword);
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on submit button on the Login Page")
    public void onButtonClick(){

        myMainPage = new MainPage(myLoginPage.onClickButton());
        throw new io.cucumber.java.PendingException();
    }
    @Then("The main page is displayed")
    public void showMainPage(){
        myMainPage.isPageSuccess();
        throw new io.cucumber.java.PendingException();
        //Assertions.assertTrue(myMainPage.isPageSuccess());
    }

}
