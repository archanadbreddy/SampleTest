package com.sample.StepDefinitions;

import Pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static helpers.PageInstances.driver;

/**
 * Created by ArchanaDyavarintiBay on 20-07-2017.
 */
public class HomePageStepDef {

    @And("^I search a product \"([^\"]*)\"$")
    public void iSearchAProduct(String Product) throws Throwable {
        new HomePage(driver).SearchItem(Product);
    }

    @And("^I add it to the Basket$")
    public void iAddItToTheBasket() throws Throwable {
        new HomePage(driver).BasketAdd();
    }




}
