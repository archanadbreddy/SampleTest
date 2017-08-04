@Feature_LS_30925
Feature: Add Planned to Advanced Search Recruitment status

  @001_LittleWoods
  Scenario Outline:  Registering a user in application
    Given I Navigate to littleWoods Application
    And I click on 'Sign In" link on the home page
    And I logged in as a "Automation" user with access to "ShopDirect" project
    Then I validate that the Error message "<message>" is displayed
    Then I log out of the application

    Examples:
      |message|
      |The log in details provided do not match our records, please try again. After 5 incorrect attempts we will lock your account and send you an email advising you what to do next.|

  @002_LittleWoods
  Scenario Outline:  Registering a user in application
    Given I Navigate to littleWoods Application
    And I search a product "<Product Name>"
    And I add it to the Basket
    And I continue Checking out as a "Automation" user with access to "ShopDirect" project

    Examples:
    |Product Name|
    |Washing machine|

