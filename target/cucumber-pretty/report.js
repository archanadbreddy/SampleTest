$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Sample.feature");
formatter.feature({
  "line": 2,
  "name": "Add Planned to Advanced Search Recruitment status",
  "description": "",
  "id": "add-planned-to-advanced-search-recruitment-status",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Feature_LS_30925"
    }
  ]
});
formatter.scenario({
  "line": 42,
  "name": "Add a product to basket and proceed to checkout",
  "description": "",
  "id": "add-planned-to-advanced-search-recruitment-status;add-a-product-to-basket-and-proceed-to-checkout",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 41,
      "name": "@004"
    }
  ]
});
formatter.step({
  "line": 43,
  "name": "I logged in as a \"Automation\" user with access to \"ShopDirect\" project taken from Excel file",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "I take a screenshot",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Automation",
      "offset": 18
    },
    {
      "val": "ShopDirect",
      "offset": 51
    }
  ],
  "location": "loginPageStepDef.iLoggedInAsAUserWithAccessToProjectTakenFromExcelFile(String,String)"
});
formatter.result({
  "duration": 76568342210,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to find element with id \u003d\u003d loginID (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 344 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027DESKTOP-3G441JV\u0027, ip: \u00279.202.55.52\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.ie.InternetExplorerDriver\nCapabilities [{browserAttachTimeout\u003d0, ie.enableFullPageScreenshot\u003dtrue, enablePersistentHover\u003dtrue, ie.forceCreateProcessApi\u003dfalse, ie.forceShellWindowsApi\u003dfalse, pageLoadStrategy\u003dnormal, ignoreZoomSetting\u003dfalse, ie.fileUploadDialogTimeout\u003d3000, version\u003d11, platform\u003dWINDOWS, nativeEvents\u003dtrue, ie.ensureCleanSession\u003dfalse, elementScrollBehavior\u003d0, ie.browserCommandLineSwitches\u003d, requireWindowFocus\u003dfalse, browserName\u003dinternet explorer, initialBrowserUrl\u003dhttp://localhost:39683/, javascriptEnabled\u003dtrue, ignoreProtectedModeSettings\u003dfalse, enableElementCacheCleanup\u003dtrue, unexpectedAlertBehaviour\u003ddismiss}]\nSession ID: eb324226-2137-46d1-9c8a-07057c4ffea0\n*** Element info: {Using\u003did, value\u003dloginID}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy16.clear(Unknown Source)\r\n\tat Pages.loginPage.EnterCredentials_Excel(loginPage.java:244)\r\n\tat com.sample.StepDefinitions.loginPageStepDef.iLoggedInAsAUserWithAccessToProjectTakenFromExcelFile(loginPageStepDef.java:72)\r\n\tat ✽.Given I logged in as a \"Automation\" user with access to \"ShopDirect\" project taken from Excel file(Sample.feature:43)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "loginPageStepDef.iTakeAScreenshot()"
});
formatter.result({
  "status": "skipped"
});
});