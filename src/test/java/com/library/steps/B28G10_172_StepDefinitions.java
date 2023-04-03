package com.library.steps;

import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B28G10_172_StepDefinitions { //4461 Borrowed Books
    LoginPage loginpage =new LoginPage();
    BorrowedBooksPage borrowedBooksPage=new BorrowedBooksPage();
    String  actualBorrowedBooks;

@Given("The {string} on the home page")
    public void theOnTheHomePage(String arg0) {
        loginpage.login(arg0);
    }

    @When("The librarian gets borrowed books numbers")
    public void theLibrarianGetsBorrowedBooksNumbers() {
        String query="select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        actualBorrowedBooks=DB_Util.getFirstRowFirstColumn();
        System.out.println("actualBorrowedBooks = " + actualBorrowedBooks);
    }

    @Then("borrowed books numbers information must match with DB")
    public void borrowedBooksNumbersInformationMustMatchWithDB() {
        String query="select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBooks= DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedBorrowedBooks = " + expectedBorrowedBooks);

        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooks);
    }
}
