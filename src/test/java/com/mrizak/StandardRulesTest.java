package com.mrizak;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StandardRulesTest {
    private int neighbours;
    private CellStatus currentStatus; 
    private final GameRules rules = new StandardRules();
    private static Map<String, CellStatus> statusMap = new HashMap<>();

    @BeforeAll
    public static void setStatusMap() {
        statusMap.put("alive", CellStatus.ALIVE);
        statusMap.put("dead", CellStatus.DEAD);
    }
    
    @Given("a cell that is {string} and {int} neighbours")
    public void aCellWithNeighbours(String key, int num) {
        currentStatus = statusMap.get(key);
        neighbours = num;
    }

    @When("I apply the standard game rules")
    public void iApplyTheStandardGameRules() {
        CellStatus newStatus = rules.newStatus(currentStatus, neighbours);
        currentStatus = newStatus;
    }

    @Then("the cell should be {string}")
    public void theCellIsDeadOrAlive(String key) {
        Assert.assertTrue(currentStatus == statusMap.get(key));
    }
}
