package Pages;

import com.gargoylesoftware.htmlunit.Page;
import helpers.PageInstances;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by ArchanaDyavarintiBay on 04-07-2017.
 */
public class loginPage extends PageInstances {
    static int counter = 3;

    public static String url;
    public static String BROWSER;

    @FindBy(id = "loginID")
    private WebElement textBoxUserName;

    @FindBy(xpath="//a[@class='header-logStateAnchor']")
    private WebElement SignInBtn;

    @FindBy(id = "loginPassword")
    private WebElement textBoxPassword;

    @FindBy(id = "loginPostcode")
    private WebElement textBoxPostCode;

    @FindBy(xpath = "//input[@id='existingCustomerSubmitButton']")
    private WebElement buttonLogin;

    @FindBy(xpath="//li[@class='postError']")
    private WebElement ErrorMsg;

    static {
        try {
            File fXmlFile = new File("Configuration.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;

            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Configuration");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    //System.out.println("Staff id : " + eElement.getAttribute("url"));
                    BROWSER = eElement.getElementsByTagName("browserType").item(0).getTextContent();
                    System.out.println(BROWSER);
                    if (BROWSER.equals("FF")) {
//                        System.setProperty("webdriver.firefox.marionette","C://Users/ArchanaDyavarintiBay/Downloads/Selenium Jar Files/geckodriver-v0.16.1-win64/geckodriver.exe");
//                        FirefoxProfile profile = new FirefoxProfile ();
//                        profile.setAcceptUntrustedCertificates (true);
//                        profile.setAssumeUntrustedCertificateIssuer (false);
//                        profile.setPreference("network.http.sendRefererHeader",1);
                        driver =new FirefoxDriver ();
                        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//                        URL hubaddress=new URL("http://9.202.55.52:4444/wd/hub");
//                        DesiredCapabilities browsertype=DesiredCapabilities.firefox();
//                        driver=new RemoteWebDriver(hubaddress,browsertype);
                        url = doc.getElementsByTagName("url").item(0).getTextContent();
                        System.out.println(url);
                        driver.navigate().to(url);
                        driver.manage().window().maximize();

                    } else if (BROWSER.equals("CH")) {
                        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ArchanaDyavarintiBay\\Downloads\\Selenium Jar Files\\chromedriver.exe");
                        driver = new ChromeDriver();
                    } else if (BROWSER.equals("IE")) {
                        System.setProperty("webdriver.ie.driver", "C:\\Users\\ArchanaDyavarintiBay\\Downloads\\Selenium Jar Files\\IEDriverServer.exe");
                        driver = new InternetExplorerDriver();
                    }else if(BROWSER.equals("Remote Machine"))
                    {
                        URL hubaddress=new URL("http://9.202.55.52:4444/wd/hub");
                        DesiredCapabilities browsertype=DesiredCapabilities.firefox();
                        //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
                        driver=new RemoteWebDriver(hubaddress,browsertype);
                    }
                    url = doc.getElementsByTagName("url").item(0).getTextContent();
                    System.out.println(url);
                    driver.navigate().to(url);
                    driver.manage().window().maximize();

                }
            }
        } catch (Exception e) {
        }
    }

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void URLNavigation(String user, String team) throws IOException, InterruptedException {

        System.out.println("enterin 1");
        loginActions(user, team);
        System.out.println("enterin 2");
        String currentURL = driver.getCurrentUrl().toLowerCase();
        while ((currentURL.contains("kickout") || currentURL.contains("session refused")
                || currentURL.contains("JBoss")
                || currentURL.contains("login.do") || currentURL.contains("login_error")) && counter > 0) {

            driver.navigate().to(url);
            driver.navigate().refresh();
            loginActions(user, team);
            currentURL = driver.getCurrentUrl().toLowerCase();
            counter--;
        }
    }

    public void loginActions(String user, String team) throws IOException, InterruptedException {

        String url = driver.getCurrentUrl();

        String environment = "PROD";
        if (url.contains("qa") || url.contains("dev") || url.contains("build"))
            environment = "QA";
        else if (url.contains("perf"))
            environment = "PERF";
        String usernameKey = team.concat(user + environment + "Username");
        String passwordKey = team.concat(user + environment + "Password");
        String PostCodeKey=team.concat(user + environment + "PostCode");
        Properties prop = new Properties();
        prop.load(new FileInputStream("Credentials.properties"));
        String userName = (String) prop.get(usernameKey);
        String passWord = (String) prop.get(passwordKey);
        String PostCode=(String)prop.get(PostCodeKey);

        SignInBtn.click();
        
        textBoxUserName.clear();
        
        textBoxUserName.sendKeys(userName);
        
        textBoxPassword.sendKeys(passWord);
        
        textBoxPostCode.clear();
        textBoxPostCode.sendKeys(PostCode);
        
        buttonLogin.click();
        
    }

    public void WrongCredentials() {
        driver.navigate().to(url);
        String currentURL = driver.getCurrentUrl().toLowerCase();
        while ((currentURL.contains("kickout") || currentURL.contains("session refused")
                || currentURL.contains("JBoss")
                || currentURL.contains("login.do") || currentURL.contains("login_error")) && counter > 0) {

            driver.navigate().to(url);
            driver.navigate().refresh();

        }
    }
    public void SignInClick() throws InterruptedException {
        if(SignInBtn.isDisplayed()) {

            SignInBtn.click();

        }else
        {
            System.out.println("Sign In button is not displayed");
        }
    }
    public void EnterCredentials(String user,String team) throws InterruptedException, AWTException, IOException {
        String url = driver.getCurrentUrl();

        String environment = "PROD";
        if (url.contains("qa") || url.contains("dev") || url.contains("build"))
            environment = "QA";
        else if (url.contains("perf"))
            environment = "PERF";
        String usernameKey = team.concat(user + environment + "Username");
        String passwordKey = team.concat(user + environment + "Password");
        String PostCodeKey=team.concat(user + environment + "PostCode");
        Properties prop = new Properties();
        prop.load(new FileInputStream("Credentials.properties"));
        String userName = (String) prop.get(usernameKey);
        String passWord = (String) prop.get(passwordKey);
        String PostCode=(String)prop.get(PostCodeKey);

        textBoxUserName.clear();

        textBoxUserName.sendKeys(userName);

        textBoxPassword.sendKeys(passWord);

        textBoxPostCode.clear();
        textBoxPostCode.sendKeys(PostCode);

        buttonLogin.click();
    }

    public void EnterCredentials_Excel(String userName,String passWord,String PostCode) throws InterruptedException, AWTException, IOException {
        String url = driver.getCurrentUrl();

        textBoxUserName.clear();

        textBoxUserName.sendKeys(userName);

        textBoxPassword.sendKeys(passWord);

        textBoxPostCode.clear();
        textBoxPostCode.sendKeys(PostCode);

        buttonLogin.click();
    }


    public void ValidateErrorMessage(String aMsg)
    {
        String eMsg=ErrorMsg.getText();
        Assert.assertEquals(aMsg,eMsg);
    }
}