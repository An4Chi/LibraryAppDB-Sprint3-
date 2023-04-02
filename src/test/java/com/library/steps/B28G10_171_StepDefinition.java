package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class B28G10_171_StepDefinition extends BookPage {

    String expectedBookName;
    String expectedISNB;
    String expectedYear;
    String expectedAuthor;
    String expectedBookCategory;


    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        addBook.click();


    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {

        addBookBookName.sendKeys(bookName);
        expectedBookName = bookName;
        System.out.println("expectedBookName = " + expectedBookName);


    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {
        addBookISBN.sendKeys(ISBN);
        expectedISNB = ISBN;
        System.out.println("expectedISNB = " + expectedISNB);


    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        addBookYear.sendKeys(year);
        expectedYear = year;
        System.out.println("expectedYear = " + expectedYear);


    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        addBookAuthor.sendKeys(author);
        expectedAuthor = author;
        System.out.println("expectedAuthor = " + expectedAuthor);

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {

        Select bookCategoryDropDown = new Select(categoryDropdown);
        bookCategoryDropDown.selectByVisibleText(bookCategory);
        expectedBookCategory=bookCategory;
        System.out.println("expectedBookCategory = " + expectedBookCategory);


    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        addBookSaveChange.click();


    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String ToastMessage) {

        Assert.assertTrue(addBookToastMessage.isDisplayed());
        Assert.assertEquals(ToastMessage,addBookToastMessage.getText());


    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {
     String query = "select books.name,books.isbn,books.year,books.author,bc.name\n" +
                "from books join book_categories bc on books.book_category_id = bc.id\n" +
                "where books.name = '"+bookName+"'";

     //   String query = "select * from books where name='Clean Code'";

        DB_Util.runQuery(query);

        System.out.println("query = " + query);

        Map<String,String> booksInfo = DB_Util.getRowMap(1);
        System.out.println("booksInfo = " + booksInfo);


    }



}
