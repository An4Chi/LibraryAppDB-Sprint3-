package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class B28G10_165_StepDefinitions {
    String actualCountIdNumbers;
    String expectedCountUniqueIdNumbers;
    List<String> actualColumnNames;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

        DB_Util.runQuery("select count(id) from users");
        actualCountIdNumbers = DB_Util.getFirstRowFirstColumn();


    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        DB_Util.runQuery("select distinct count(id) from users");
        expectedCountUniqueIdNumbers = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedCountUniqueIdNumbers, actualCountIdNumbers);

    }


    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {
        DB_Util.runQuery("select * from users");
        actualColumnNames = DB_Util.getAllColumnNamesAsList();
    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> expectedColumnNames) {
        Assert.assertEquals(expectedColumnNames, actualColumnNames);

    }
}
