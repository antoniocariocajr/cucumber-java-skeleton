Feature: Hear shout
  Shouty allows users to "hear" other users "shouts" as long as they are close enough to each other.
  To do:
   - only shout to people within a certain distance

  Rule: Shouts can be heard by other users
    Scenario: Listener is within range
      Given a person named Lucy
      And a person named Sean
      When Sean shouts "free bagels at Sean's"
      Then Lucy hears Sean's message

    Scenario: Listener hears different message
      Given Lucy is located 150 metres from Sean
      When Sean shouts "free coffee!"
      Then Lucy hears different Sean's message

  Rule: shouts should only be heard if listener is within range
    Scenario: Listener is within range
    Scenario: Listener is out of range