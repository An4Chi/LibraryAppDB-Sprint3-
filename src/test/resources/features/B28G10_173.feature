Feature: As a librarian, I want to know which genre of books is being borrowed the most

  @db  @B28G10-186
Scenario: Verify the common book genre that’s being borrowed.
Given establish the database connection
When Execute query to find most popular book genre
Then verify "Fantasy" is the most popular book genre.
