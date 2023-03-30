package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class B28G10_170_StepDefinitions {

    BookPage bookPage = new BookPage();
    LoginPage loginPage = new LoginPage();
    WebDriver driver;


    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        bookPage.addBook.click();
        System.out.println("Clicked add book");

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {

        bookPage.addBookBookName.sendKeys(bookName);
        System.out.println("Entered book name");

    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {

        bookPage.addBookISBN.sendKeys(ISBN);
        System.out.println("Entered ISBN number");


    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        bookPage.addBookYear.sendKeys(year);
        System.out.println("Entered year");
    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        bookPage.addBookAuthor.sendKeys(author);
        System.out.println("Entered author");

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {

        Select bookCategoryDropDown = new Select(driver.findElement(By.xpath("//select[@id='book_group_id']")));

    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String string) {

    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String string) {

    }


}
