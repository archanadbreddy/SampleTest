package com.sample.StepDefinitions;

import Pages.DBExecutor;
import Pages.HomePage;
import Pages.XMLProcessor;
import Pages.loginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ExcelLib;
import helpers.PageInstances;
import helpers.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;

/**
 * Created by ArchanaDyavarintiBay on 04-07-2017.
 */
public class loginPageStepDef extends PageInstances {

//    @Autowired@Lazy
//    public loginPage LoginPage;

    @Given("^I logged in as a \"([^\"]*)\" user with access to \"([^\"]*)\" project$")
    public void i_logged_in_as_a_user_with_access_to_project(String user, String team) throws Throwable {
        new loginPage(driver).URLNavigation(user,team);
    }

    @Given("^I Navigate to littleWoods Application$")
    public void iNavigateToLittleWoodsApplication() throws Throwable {
        new loginPage(driver).WrongCredentials();
    }

    @And("^I click on 'Sign In\" link on the home page$")
    public void iClickOnSignInLinkOnTheHomePage() throws Throwable {
        new loginPage(driver).SignInClick();
    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAndAnd(String username, String password, String PostalCode) throws Throwable {
        new loginPage(driver).EnterCredentials_Excel(username,password,PostalCode);
    }

    @Then("^I validate that the Error message \"([^\"]*)\" is displayed$")
    public void iValidateThatTheErrorMessageIsDisplayed(String aMsg) throws Throwable {
        new loginPage(driver).ValidateErrorMessage(aMsg);
    }


    @Given("^I logged in as a \"([^\"]*)\" user with access to \"([^\"]*)\" project taken from Excel file$")
    public void iLoggedInAsAUserWithAccessToProjectTakenFromExcelFile(String user, String team) throws Throwable {
        String xlPath="C:/Users/ArchanaDyavarintiBay/Documents/sample/ExcelData.xlsx";
        String sheetName="Sheet1";
        int rc= ExcelLib.getRowCount(xlPath,sheetName);
        System.out.println(rc);
        for(int i=1;i<=rc;i++)
        {
            String un=ExcelLib.getCellValue(xlPath,sheetName,i,0);
            String pw=ExcelLib.getCellValue(xlPath,sheetName,i,1);
            String pc=ExcelLib.getCellValue(xlPath,sheetName,i,2);
            System.out.println("un : "+un);
            System.out.println("pwd : "+pw);
            System.out.println("pc : "+pc);

            new loginPage(driver);
            new loginPage(driver).SignInClick();
            new loginPage(driver).EnterCredentials_Excel(un,pw,pc);
        }
    }

    @Given("^I Work with DB$")
    public void iWorkWithDB() throws Throwable {
        String query = new XMLProcessor(driver).getSqlQueryByScenarioName("DealsDB_200909");
        List<Map<String, Object>> dbValue= new DBExecutor(driver).getDBVerificationResult(query);
        //boolean result =  searchAndAlertsWindow.verifyIfAlertIsEnabledInDatabase(dbValue);
    }

    @And("^I continue Checking out as a \"([^\"]*)\" user with access to \"([^\"]*)\" project$")
    public void iContinueCheckingOutAsAUserWithAccessToProject(String user, String team) throws Throwable {
        new HomePage(driver).Checkout_BeforeLogin(user,team);
    }

    @Then("^I continue Checking out$")
    public void iContinueCheckingOut() throws Throwable {
        new HomePage(driver).Checkout_AfterLogin();
    }


    @And("^I take a screenshot$")
    public void iTakeAScreenshot() throws Throwable {
        new ScreenShot(driver).getScreenShot();
    }
}
