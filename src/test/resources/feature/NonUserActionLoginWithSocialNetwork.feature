@login02
Feature: NonUser action on form login

  Background:
    Given the user opens the web page

  Scenario Login with Facebook
    Given the user tries to login with facebook
    When switch to handles window
    Then the user sees title "Facebook" on the new window

  Scenario: Login with Google
    Given the user tries to login with google
    When switch to handles window
    Then the user sees title "Sign In - Google Accounts" on the new window

  Scenario: Login with Google
    Given the user tries to login with apple
    When switch to handles window
    Then the user sees title "Sign in with Apple ID" on the new window
