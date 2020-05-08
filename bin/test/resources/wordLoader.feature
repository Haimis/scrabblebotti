Feature: As a user I can close file
    Scenario: file is closed
        Given everything is initialized
        When  file is read
        Then  there should be no exception