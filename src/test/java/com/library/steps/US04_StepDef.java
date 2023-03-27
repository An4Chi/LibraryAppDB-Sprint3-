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

    String classBookName;

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
        navigateModule(string);
    }
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        search.sendKeys(bookName);
        this.classBookName = bookName;
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        editBook(classBookName).click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        DB_Util.runQuery("select * from books where name='"+classBookName+"';");
        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName =bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedDesc = bookInfo.get("description");

        String actualBookName = bookName.getAttribute("value");
        String actualAuthorName = author.getAttribute("value");
        String actualISBN = isbn.getAttribute("value");
        String actualYear = year.getAttribute("value");
        String actualDesc = description.getAttribute("value");



        Assert.assertEquals(actualBookName,expectedBookName);
        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualISBN,expectedISBN);
        Assert.assertEquals(actualAuthorName,expectedAuthorName);
        Assert.assertEquals(actualDesc,expectedDesc);



    }
}
