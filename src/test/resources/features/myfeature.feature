Feature: Gmail mail compose

  Scenario: 
    Given open "chrome" browser
    And launch site using "http://www.gmail.com"
    When do login using "g.sanjaykumar92" and "gsk@09091991" credentials
    Then compose is displayed
    When click on compose and fill fields and send mail and check response
      | to                   	  | subject   | body      | attachment                     |
      | g.sanjaykumar92@gmail.com | wishes    | hi bro    | F:\my pics       				|
      | g.sanjaykumar92@gmail.com | test mail | hi friend | F:\my pics 						|
    When do logout
    Then login page should be redisplayed
    When close site