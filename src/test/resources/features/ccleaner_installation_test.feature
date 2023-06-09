@all

Feature: CCleaner installation process test

  @download
  Scenario: user downloads the CCleaner desktop app
    Given user downloads the desktop app

  @install
  Scenario: user installs the CCleaner desktop app
    Given user confirms the CCleaner installer is opened
    When user checks the ACR-065 guideline
    And user checks the ACR-040 guideline
    And user checks the ACR-046 guideline
    And user checks the ACR-055 guideline
    Then user installs and runs the app