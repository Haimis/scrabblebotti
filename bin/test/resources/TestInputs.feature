Feature: As a user I can enter different inputs
    Scenario: short input
        When  letters "avion" are entered
        Then  it should not take longer than second to form words

    Scenario: long input
        When  all alphabets are entered 100 times
        Then  it should not take longer than second to form words