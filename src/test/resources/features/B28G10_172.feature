
Feature: As a librarian, I want to know borrowed books number

   @db @ui @B28G10-194

  Scenario: B28G10-172 verify the total amount of borrowed books
    Given The "librarian" on the home page
    When The librarian gets borrowed books numbers
    Then borrowed books numbers information must match with DB


   ##4461 Borrowed Books