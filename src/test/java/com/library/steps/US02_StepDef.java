package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_StepDef {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String expectedBorrowedBooksNumber;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        loginPage.login(string);
    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        expectedBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(id) from book_borrow where is_returned = 0;");
        String actualBorrowedBookNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBookNumber);
    }
}
