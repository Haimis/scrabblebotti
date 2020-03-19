Feature: As a user I can add words to dictionary

    Scenario: user can add words to dictionary
        Given dictionary is initialized
        When  new word "koira" is added
        Then  there should be  1 words in dictionary

    Scenario: the word should be retrieved from dictionary
        Given dictionary is initialized
        When  new word "kissa" is added
        Then  "kissa" should be the first word in dictionary