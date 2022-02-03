package com.mrizak;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class Blinker {
    private Grid grid;
    private static Map<String, Disposition> dispositionMap = new HashMap<>();

    @BeforeAll
    public static void setDispositionMap() {
        dispositionMap.put("horizontal", Personas.HORIZONTAL_BLINKER);
        dispositionMap.put("vertical", Personas.VERTICAL_BLINKER);
    }

    @Before
    public void setGrid() {
        grid = Grid.create(10, new StandardRules());
    }

    @Given("a {string} blinker")
    public void aHorizontalBlinker(String key) {
        grid.applyInitialDisposition(dispositionMap.get(key));
    }

    @When("I run a new generation")
    public void iRunANewGeneration() {
        grid.nextGeneration();
    }

    @Then("I should have a {string} blinker")
    public void iShouldHaveAVerticalBlinker(String key) {
        Assert.assertTrue(grid.isEqualTo(dispositionMap.get(key)));
    }
}
