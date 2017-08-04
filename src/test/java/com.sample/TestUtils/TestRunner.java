package com.sample.TestUtils;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import static helpers.PageInstances.driver;

/**
 * Created by ArchanaDyavarintiBay on 03-07-2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"json:target/cucumber.json","html:target/cucumber-pretty"},

        glue = {"com.sample/StepDefinitions"}
        , features = {"C://Users/ArchanaDyavarintiBay/Documents/sample/src/test/resources"}
        , tags = {"@004"}

)
public class TestRunner extends AbstractTestNGCucumberTests
{



@BeforeClass
    public static void preCondition(){


}

    @AfterClass
    public static void postCondition() throws IOException {



    }




}
