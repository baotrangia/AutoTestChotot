@login01
Feature: NonUser action on form login

  Background:
    Given the user opens the web page

  Scenario Login with non information
    Given the user clicks on button login
    Then the user sees error messages "Vui lòng nhập Số điện thoại." is displayed

  Scenario: Login with non password
    Given the user fills on "tel" with value "0975184342"
    When the user clicks on button login
    Then the user sees error messages "Vui lòng nhập Mật khẩu." is displayed

  Scenario: Login with short phone number
    Given the user fills on "tel" with value "01"
    When the user clicks on button login
    Then the user sees error messages "Số điện thoại có ít nhất 10 kí tự." is displayed

  Scenario: Login with short password
    Given the user fills on "password"
    And  the user fills on "tel" with value "0975184342"
    When the user clicks on button login
    Then the user sees error messages "Mật khẩu có ít nhất 5 kí tự." is displayed

