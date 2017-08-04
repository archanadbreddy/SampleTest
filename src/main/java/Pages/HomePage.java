package Pages;

import helpers.PageInstances;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by ArchanaDyavarintiBay on 20-07-2017.
 */
public class HomePage extends PageInstances
{
    @FindBy(id="header-searchInput")
    private WebElement SearchBox;

    @FindBy(xpath="//input[@class='header-searchBtn']")
    private WebElement Searchbtn;

    @FindBy(xpath="(//a[@class='productTitle'])[1]/h3/span")
    private WebElement ProductLnk;

    @FindBy(id="addToBasketButton")
    private WebElement addToBasketBtn1;

    @FindBy(xpath=".//*[@id='dialogProdContent']/ul/li/div[1]/div[2]/span[1]")
    private WebElement ServiceGuaranteeDropDown;

    @FindBy(xpath=".//*[@id='dialogProdContent']/ul/li/fieldset/ul/li[3]/label/span")
    private WebElement warrantyRadioBtn;

    @FindBy(id="addToBasketButton2")
    private WebElement addToBasketBtn2;

    @FindBy(xpath="//a[text()='Go to basket']")
    private WebElement GoToBasketBtn;


    @FindBy(id="basketContinueButtonTop")
    private WebElement basketContinueBtn;

    @FindBy(id="deliveryContinueButton")
    private WebElement deliveryContinueBtn;

    @FindBy(id="propertyType0")
    private WebElement propertyTypeDropDown;




    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void SearchItem(String Product) throws InterruptedException {
        Thread.sleep(3000);
        SearchBox.sendKeys(Product);
        Thread.sleep(3000);
        Searchbtn.click();
        Thread.sleep(3000);


    }
    public void BasketAdd() throws InterruptedException {
        ProductLnk.click();
        Thread.sleep(3000);
        addToBasketBtn1.click();
        Thread.sleep(1000);
        ServiceGuaranteeDropDown.click();
        Thread.sleep(1000);
        warrantyRadioBtn.click();
        Thread.sleep(1000);
        addToBasketBtn2.click();
        Thread.sleep(2000);
        GoToBasketBtn.click();
    }

    public void Checkout_AfterLogin() throws InterruptedException {
        basketContinueBtn.click();
        Thread.sleep(3000);
        Select select=new Select(propertyTypeDropDown);
        select.selectByValue("House");
        Thread.sleep(2000);
        deliveryContinueBtn.click();

    }
    public void Checkout_BeforeLogin(String user,String team) throws AWTException, IOException, InterruptedException {
        basketContinueBtn.click();
        Thread.sleep(3000);
        new loginPage(driver).EnterCredentials(user,team);
        Thread.sleep(3000);
        basketContinueBtn.click();
        Thread.sleep(3000);
        Select select=new Select(propertyTypeDropDown);
        select.selectByValue("House");
        Thread.sleep(2000);
        deliveryContinueBtn.click();

    }

}
