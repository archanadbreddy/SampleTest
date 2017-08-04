package Pages;

import helpers.PageInstances;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ArchanaDyavarintiBay on 20-07-2017.
 */
public class MyAccount extends PageInstances{
    @FindBy(xpath="//a[@class='header-logStateAnchor header-logStateAnchor-isLogged']")
    private WebElement MyAccountLink;

    @FindBy(xpath="//a[contains(text(),'My Details')]")
    private WebElement MyDetailsTab;

    @FindBy(xpath="//a[contains(text(),'Edit address book')]")
    private WebElement EditAddressLink;

    @FindBy(id="addNewAddressBtn")
    private WebElement AddNewAddressBtn;

    @FindBy(id="houseNum")
    private WebElement HouseNumTextBox;

    @FindBy(id="postcode")
    private WebElement PostCodeTextBox;

    @FindBy(id="findAddressButton")
    private WebElement FindAddressBtn;

    @FindBy(id="confirmAddressLookup")
    private WebElement confirmAddressLookup;

    @FindBy(id="confirmAddressButton")
    private WebElement confirmAddressBtn;

    @FindBy(id="confirmedAddress")
    private WebElement confirmedAddress;


    @FindBy(xpath="//input[@class='header-logStateInput']")
    private WebElement logoutLnk;




    public MyAccount(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void MyAccountClick()
    {
        if(MyAccountLink.isDisplayed())
        {
            MyAccountLink.click();
        }else {
            System.out.println("My Account link is not displayed");
        }
    }

    public void MyDetailsClick()
    {
        if(MyDetailsTab.isDisplayed())
        {
            MyDetailsTab.click();
        }else {
            System.out.println("My Details Tab is not displayed");
        }
    }

    public String AddAddress(String HouseNum, String PostCode)
    {
        EditAddressLink.click();
        AddNewAddressBtn.click();
        HouseNumTextBox.sendKeys(HouseNum);
        PostCodeTextBox.sendKeys(PostCode);
        FindAddressBtn.click();
        Select select=new Select(confirmAddressLookup);
        select.selectByIndex(1);
        List<WebElement> list = select.getOptions();
        Address=list.get(1).getText();
        confirmAddressBtn.click();
        return Address;

    }

    public void ValidateAddress()
    {
        if(Address.equals(confirmedAddress))
        {
            Assert.assertTrue(true);
        }else
        {
            Assert.assertFalse(false);
        }
    }

    public void logout()
    {
        logoutLnk.click();
        //driver.close();
    }
}
