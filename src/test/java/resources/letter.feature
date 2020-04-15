Feature: As a user I can read files with word loader

    Scenario: user can open file with word loader
        Given word loader is initialized
        When  user opens file
        Then  there should be no exception

    Scenario: user can read files with word loader
        Given word loader is initialized
        And   user opens file
        When  file user reads file
        Then  something should be returned

    Scenario: user can close the reader
        Given word loader is initialized
        And   user opens file
        When  user closes the word loader
        Then  there should be no exception
