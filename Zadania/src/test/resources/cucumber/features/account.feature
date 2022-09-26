Feature: Adding address to existing users

  Scenario Outline: new account can be created for given users

    Given an open browser with https://mystore-testlab.coderslab.pl
    And user is registered with <mail> and <password>
    When new address form is filled with <alias> and <address> and <city> and <zipcode> and <phone>
    Then new address is created


    Examples:
      | alias | address | city   | zipcode  | phone      |
      | Noname  | Testerska 5  | Legnica | 59220    | +48123456789  |
