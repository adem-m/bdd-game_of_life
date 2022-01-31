package com.mrizak;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Blinker {
    private Grid grid;

    @Given("a horizontal blinker")
    public void aHorizontalBlinker() {
        grid = Grid.create(10, new StandardRules());
        grid.applyInitialDisposition(new InitialDisposition(List.of(
                new Coordinates(3, 4),
                new Coordinates(3, 5),
                new Coordinates(3, 6)
        )));
    }

    @When("I run a new generation")
    public void iRunANewGeneration() {
        grid.nextGeneration();
    }

    @Then("I should have a vertical blinker")
    public void iShouldHaveAVerticalBlinker() {
        List<List<Cell>> cells = grid.getCells();
        Assert.assertEquals(CellStatus.ALIVE, cells.get(2).get(5).getStatus());
        Assert.assertEquals(CellStatus.ALIVE, cells.get(3).get(5).getStatus());
        Assert.assertEquals(CellStatus.ALIVE, cells.get(4).get(5).getStatus());
    }
}
