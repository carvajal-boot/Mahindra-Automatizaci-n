Feature: Login success at AVE

  @avianca
  Scenario Outline: Validate that the user login success at AVE
    Given open the page avianca <row>
      | Route Excel | src/test/resources/datadriven/Data_Avianca.xlsx |
      | Tab    | Avianca                                       |
    When complete the type of flight
    And select the best price of fligth
    Then validate the informattion of fligth
    Examples:
    | row |
    | 1   |
