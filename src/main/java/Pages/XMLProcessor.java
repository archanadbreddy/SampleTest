package Pages;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import helpers.PageInstances;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;



@Component
public class XMLProcessor extends PageInstances
{
    private Document doc;

    public XMLProcessor(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public String getSqlQueryByScenarioName(String scName)  {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // never forget this!
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = (Document) builder.parse("SQLQueries.xml");

            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xpath = xpathfactory.newXPath();

            XPathExpression expr = xpath.compile(String.format("//SQLqueries//query[@scenario_name='%s']", scName));
            String result = expr.evaluate(doc);
            return result;
        } catch (Exception e) {
            System.out.println("Got exception during retrieving SQL query from SQLQUERY.xml" + e.getMessage());
        }
        return null;
    }

}
