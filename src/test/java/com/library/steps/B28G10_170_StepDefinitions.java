package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class B28G10_170_StepDefinitions extends BookPage {

    BookPage bookPage = new BookPage();
    WebDriver driver;
    String expectedBookName;
    String expectedISBN;
    String expectedYear;
    String expectedAuthor;
    String expectedCategory;




    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        bookPage.addBook.click();
        System.out.println("Clicked add book");

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {

        bookPage.addBookBookName.sendKeys(bookName);
        System.out.println("Entered book name");
        expectedBookName = bookName;
        System.out.println("expectedBookName = " + expectedBookName);

    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {

        bookPage.addBookISBN.sendKeys(ISBN);
        System.out.println("Entered ISBN number");
        expectedISBN = ISBN;
        System.out.println("expectedISBN = " + expectedISBN);


    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        bookPage.addBookYear.sendKeys(year);
        System.out.println("Entered year");
        expectedYear = bookPage.addBookYear.getAttribute("value");
    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        bookPage.addBookAuthor.sendKeys(author);
        System.out.println("Entered author");
        expectedAuthor = bookPage.addBookAuthor.getAttribute("value");

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {

    //    WebElement bookCategoryDropdown = driver.findElement(By.xpath("//select[@id='book_group_id']"));
        Select bookCategoryDropdown = new Select(categoryDropdown);
        bookCategoryDropdown.selectByVisibleText(bookCategory);
        System.out.println("Book category selected");
        expectedCategory = bookCategory;
        BrowserUtil.waitFor(2);

    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        bookPage.addBookSaveChange.click();
        System.out.println("Saved change");

    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String ToastMessage) {

        String actualMessage = bookPage.addBookToastMessage.getText();
     //   String expectedMessage = ToastMessage;

        Assert.assertEquals(actualMessage,ToastMessage);

    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {

        String query = "select books.name,isbn,year,author,bc.name category_name" + "from books" + "join book_categories bc on books.book_category_id = bc.id" + "where books.name ='"+bookName+"'";
        DB_Util.runQuery(query);

        Map<String,String> bookInfo = DB_Util.getRowMap(1);
        System.out.println("bookInfo = " + bookInfo);

        String actualBookName = bookInfo.get("name");
        System.out.println("actualBookName = " + actualBookName);
        String actualISBN = bookInfo.get("isbn");
        String actualYear = bookInfo.get("year");
        String actualAuthor = bookInfo.get("author");
        String actualCategory = bookInfo.get("category_name");
        System.out.println("actualCategory = " + actualCategory);

        Assert.assertEquals(actualBookName,expectedBookName);
        Assert.assertEquals(actualISBN,expectedISBN);
        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualAuthor,expectedAuthor);
        Assert.assertEquals(actualCategory,expectedCategory);








    }


}
