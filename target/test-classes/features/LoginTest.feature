Feature: login

  @ValidCase @SomeTags
  Scenario Outline: Successful login using valid account
    Given Login form in login page
    When Submit username using "<username>" and password using "<password>"
    Then Success login

    Examples:
      | username             | password |
      | 00000sfc             | ex42sfce   |
      | testauto             | test       |

