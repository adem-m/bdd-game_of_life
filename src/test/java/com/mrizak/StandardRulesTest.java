package com.mrizak;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StandardRulesTest {
    private int neighbours;
    private CellStatus currentStatus;
    private final GameRules rules = new StandardRules();

    @ParameterType("alive|dead")
    public CellStatus cellStatus(String statusName) {
        switch (statusName) {
            case "alive":
                return CellStatus.ALIVE;
            case "dead":
                return CellStatus.DEAD;
            default:
                throw new IllegalArgumentException("Unknown cell status " + statusName);
        }
    }

    @Given("a cell that is {cellStatus} with {int} neighbours")
    public void aCellWithNeighbours(CellStatus status, int num) {
        currentStatus = status;
        neighbours = num;
    }

    @When("I apply the standard game rules")
    public void iApplyTheStandardGameRules() {
        currentStatus = rules.newStatus(currentStatus, neighbours);
    }

    @Then("the cell should be {cellStatus}")
    public void theCellIsDeadOrAlive(CellStatus status) {
        Assert.assertSame(currentStatus, status);
    }
}
