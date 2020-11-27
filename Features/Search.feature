Feature:SearchJPM
  Scenario Outline: Search "J P Morgan" and verify logo is present in first link
    Given User launches a browser
    When User opens google
    And User searches string "<searchString>"
    And User clicked on first link
    Then Verify J P Morgan Logo should be present
    And close the browser
    Examples:
      |searchString|
      |J. P. Morgan|
      |j.p.morgan  |
      |j p morgan  |
      |J P Morgan|