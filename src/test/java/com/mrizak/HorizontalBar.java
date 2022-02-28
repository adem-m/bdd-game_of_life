package com.mrizak;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class HorizontalBar {
    private Grid grid;
    private StartingGrid startingGrid;

    public HorizontalBar(StartingGrid startingGrid) {
        this.startingGrid = startingGrid;
    }

    private CellStatus cellStatus(String statusName) {
        switch (statusName) {
            case "ALIVE":
                return CellStatus.ALIVE;
            case "DEAD":
                return CellStatus.DEAD;
            default:
                throw new IllegalArgumentException("Unknown cell status " + statusName);
        }
    }

    @Given("the starting grid")
    public void theStartingGrid() {
        grid = startingGrid.grid;
    }    

    @Then("the grid points should have the following values")
    public void theGridPointsShouldHaveTheFollowingValues(DataTable dataTable) {
        dataTable.asMaps().forEach(dataLine -> {
            String[] coordinates = dataLine.get("coordinates").split(",");
            Integer x = Integer.parseInt(coordinates[0].trim());
            Integer y = Integer.parseInt(coordinates[1].trim());
            CellStatus expectedStatus = this.cellStatus(dataLine.get("status"));

            System.out.println(expectedStatus.toString());
            Assertions.assertSame(expectedStatus, this.grid.getCellAt(x, y).getStatus());
        });
    }
}
