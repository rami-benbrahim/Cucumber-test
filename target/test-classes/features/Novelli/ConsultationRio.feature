Feature: RIO CODE

  @Rio @SomeTags
  Scenario Outline: rio code
    Given se connecter avec "<username>" / "<password>"
    When je cherche la ligne "<ligne>" et j'ouvre le RIO acte
    Then verifier rio visible "<riocode>"


    Examples:
      | username | password | ligne    |riocode|
      | 00000sfc | ex42sfce |0622922692|02P09REXJCAA|
      #| 00000sfc | ex42sfce |0622922692|02P09REXJCAJ|