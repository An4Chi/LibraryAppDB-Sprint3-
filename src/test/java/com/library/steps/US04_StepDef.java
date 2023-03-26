package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US04_StepDef extends BookPage{

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
        navigateModule(string);
    }
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String string) {
        search.sendKeys(string);
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        editBook("Clean Code").click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        DB_Util.runQuery("select * from books where name='Clean Code';");
        Map<String, String> rowMap = DB_Util.getRowMap(1);
        Assert.assertEquals(bookName.getText(),rowMap.get("name"));
        Assert.assertEquals(year.getText(),rowMap.get("year"));
        Assert.assertEquals(isbn.getText(),rowMap.get("isbn"));



    }
}
