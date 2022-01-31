package com.mrizak;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Blinker {
    private Grid grid;

    @Given("a horizontal blinker")
    public void aHorizontalBlinker() {
        grid = Grid.create(10, new StandardRules());
        grid.applyInitialDisposition(Personas.HORIZONTAL_BLINKER);
    }

    @When("I run a new generation")
    public void iRunANewGeneration() {
        grid.nextGeneration();
    }

    @Then("I should have a vertical blinker")
    public void iShouldHaveAVerticalBlinker() {
        Assert.assertTrue(grid.isEqualTo(Personas.VERTICAL_BLINKER));
    }
}
