@azure
Feature: Sample Azure Testing

  @login
  Scenario: Login To OrangeHRM
    Given User launches "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters "username"
    When User enters "password"
    And Click on login button
    Then Verify if user is logged in or not

  @applyLeave
  Scenario: Apply Leave
    Given User launches "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters "username"
    When User enters "password"
    And Click on login button
    Then Verify if user is logged in or not
    When User opens "Leave" tab
    And User switches to "Apply" tab

  @recruitment
  Scenario: Recruitment
    Given User launches "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters "username"
    When User enters "password"
    And Click on login button
    Then Verify if user is logged in or not
    When User opens "Recruitment" tab
    And User switches to "Vacancies" tab


