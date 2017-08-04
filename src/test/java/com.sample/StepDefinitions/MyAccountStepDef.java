package com.sample.StepDefinitions;

import Pages.MyAccount;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static helpers.PageInstances.driver;

/**
 * Created by ArchanaDyavarintiBay on 20-07-2017.
 */
public class MyAccountStepDef
{
    @And("^I click on 'My Details' under 'My Account'$")
    public void iClickOnMyDetailsUnderMyAccount() throws Throwable {
        new MyAccount(driver).MyDetailsClick();
    }

    @And("^I click on 'My Account' in Home Page$")
    public void iClickOnMyAccountInHomePage() throws Throwable {
        new MyAccount(driver).MyAccountClick();
    }

    @And("^I add a 'New Address' by entering \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iAddANewAddressByEnteringAnd(String HouseNumber, String PostalCode) throws Throwable {
        new MyAccount(driver).AddAddress(HouseNumber,PostalCode);
    }

    @Then("^I validate that the new Address has reflected under Address tab$")
    public void iValidateThatTheNewAddressHasReflectedUnderAddressTab() throws Throwable {
        new MyAccount(driver).ValidateAddress();
    }


    @Then("^I log out of the application$")
    public void iLogOutOfTheApplication() throws Throwable {
        new MyAccount(driver).logout();
    }
}
