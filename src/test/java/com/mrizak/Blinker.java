package com.mrizak;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Blinker {
    private Grid grid;

    @ParameterType("horizontal|vertical")
    public Disposition disposition(String dispositionName) {
        switch (dispositionName) {
            case "horizontal":
                return Personas.HORIZONTAL_BLINKER;
            case "vertical":
                return Personas.VERTICAL_BLINKER;
            default:
                throw new IllegalArgumentException("Unknown disposition " + dispositionName);
        }
    }

    @Before
    public void setGrid() {
        grid = Grid.create(10, new StandardRules());
    }

    @Given("a {disposition} blinker")
    public void aStartBlinker(Disposition initial) {
        grid.applyInitialDisposition(initial);
    }

    @When("I run a new generation")
    public void iRunANewGeneration() {
        grid.nextGeneration();
    }

    @Then("I should have a {disposition} blinker")
    public void iShouldHaveAnEndBlinker(Disposition end) {
        Assert.assertTrue(grid.isEqualTo(end));
    }
}
