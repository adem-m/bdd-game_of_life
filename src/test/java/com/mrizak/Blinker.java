package com.mrizak;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Blinker {
    private Grid grid;
    private StartingGrid startingGrid;

    public Blinker(StartingGrid startingGrid) {
        this.startingGrid = startingGrid;
    }

    @ParameterType("horizontal|vertical")
    public Disposition disposition(String dispositionName) {
        switch (dispositionName) {
            case "horizontal":
                return StartingGrid.HORIZONTAL_BAR;
            case "vertical":
                return StartingGrid.VERTICAL_BAR;
            default:
                throw new IllegalArgumentException("Unknown disposition " + dispositionName);
        }
    }

    @Before
    public void setGrid() {
        grid = this.startingGrid.grid;
        grid.applyInitialDisposition(StartingGrid.HORIZONTAL_BAR);
    }

    @Given("{int} generation(s) have/has been produced")
    public void generationProducedTime(int generations) {
        for(int i = 0; i < generations; i++) {
            grid.nextGeneration();
        }
    }

    @When("the next generation is produced")
    public void theNextGenerationIsProduced() {
        grid.nextGeneration();
    }

    @Then("the blinker should be {disposition}")
    public void theBlinkerShoudBeDisposition(Disposition end) {
        Assert.assertTrue(grid.isEqualTo(end));
    }
}
