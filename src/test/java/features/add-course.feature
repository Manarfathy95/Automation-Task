Feature: add course

  @web
  Scenario: verify that the user can add course successfully
    Given Navigate to winjigo website
    And I click the login link
    When I enter username "testregister@aaa.com" and password "Wakram_123"
    And I open courses Page
    And I fill course basic info:
      | Course Name | Subject | Grade | Course Criteria  |
      | arabic       | Others  | 4     | Final Assessment |
    And  I Back to courses list page
    Then I should see the course title is displayed
