@Feature_LS_30925
Feature: Add Planned to Advanced Search Recruitment status

  @001
  Scenario Outline:  Validate Error message when you login using wrong credentials
    Given I Navigate to littleWoods Application
    And I click on 'Sign In" link on the home page
    And I logged in as a "Automation" user with access to "ShopDirect" project
    Then I validate that the Error message "<message>" is displayed
    Then I log out of the application

    Examples:
    |message|
    |The log in details provided do not match our records, please try again. After 5 incorrect attempts we will lock your account and send you an email advising you what to do next.|

  @002
  Scenario Outline:  Add a New Address and Validate if it is added
    Given I logged in as a "Automation" user with access to "ShopDirect" project
    And I click on 'My Account' in Home Page
    And I click on 'My Details' under 'My Account'
    And I add a 'New Address' by entering "<House Number>" and "<Postal Code>"
    Then I validate that the new Address has reflected under Address tab
    Then I log out of the application

    Examples:
    |House Number|Postal Code|
    |39          |l13ed      |

  @003
  Scenario Outline:  Add a product to basket and proceed to checkout
    Given I logged in as a "Automation" user with access to "ShopDirect" project
    And I search a product "<Product Name>"
    And I add it to the Basket
    Then I continue Checking out


    Examples:
      |Product Name|Postal Code|
      |Washing Machine          |l13ed      |

  @004
  Scenario:  Add a product to basket and proceed to checkout
    Given I logged in as a "Automation" user with access to "ShopDirect" project taken from Excel file
    And I take a screenshot


    @005
    Scenario:  Add a product to basket and proceed to checkout
      Given I Work with DB










