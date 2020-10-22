@login #apply to the all test scenarios
Feature: Login
  As user I want to be able to login under different roles

  Background: # Given command will be  created only once and apply to all the other scenarios
    Given user is on the landing page

  @scenario_1
  Scenario: Login as a sales manager
   # Given user is on the landing page
    When user logs in
    Then user should see dashboard page

  @scenario_2
  Scenario: Login as a driver
   # Given user is on the landing page
    When user logs in
    Then user should see dashboard page

  @scenario_3
  Scenario: Login as a store manager
   # Given user is on the landing page
    When user logs in
    Then user should see dashboard page

  @parametrized_test  @BUG_BugID #just to be able to locate the bug/issue in the jira and follow up.!
  Scenario: Parametrized login
   # Given user is on the landing page
    When user logs in as a "store manager"
    Then user should see dashboard page
  #driver, store, sales managers are the parameter above and "" allows us to do parameterization which helps reaping steps.!

  @negative_login
  Scenario: Invalid password
   # Given user is on the landing page
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @scenario_outline
  Scenario Outline: Login under different credentials as <username>
    When user enters "<username>" and "<password>"
    Then user should be able to see Dashboard page title

    Examples:
      |     username        |     password     |
      |     user10          |     UserUser123  |
      |     user15          |     UserUser123  |
      |     user22          |     UserUser123  |
      |     user110         |     UserUser123  |
      |     storemanager85  |     UserUser123  |
      |     storemanager120 |     UserUser123  |
      |     storemanager110 |     UserUser123  |

