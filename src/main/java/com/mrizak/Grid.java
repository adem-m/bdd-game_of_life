package com.mrizak;

import java.util.ArrayList;
import java.util.List;

public final class Grid {
    private List<List<Cell>> cells;
    private int generation;
    private final GameRules gameRules;

    private Grid(List<List<Cell>> cells, int generation, GameRules gameRules) {
        this.cells = cells;
        this.generation = generation;
        this.gameRules = gameRules;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public Cell getCellAt(int x, int y) {
        return this.cells.get(x).get(y);
    }

    public static Grid create(int size, GameRules gameRules) {
        List<List<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(CellStatus.DEAD, new Coordinates(i, j)));
            }
            cells.add(row);
        }
        return new Grid(cells, 1, gameRules);
    }

    public void display() {
        System.out.printf("Generation %d\n%n", generation);
        for (List<Cell> cell : cells) {
            for (Cell cell1 : cell) {
                System.out.print(cell1.getStatus() == CellStatus.ALIVE ? "#" : ".");
            }
            System.out.println();
        }
    }

    private int getCellNeighbours(Coordinates coordinates) {
        List<Cell> neighbours = new ArrayList<>();
        neighbours.add(cells.get(getPreviousValue(coordinates.getX())).get(getPreviousValue(coordinates.getY())));
        neighbours.add(cells.get(getPreviousValue(coordinates.getX())).get(coordinates.getY()));
        neighbours.add(cells.get(getPreviousValue(coordinates.getX())).get(getNextValue(coordinates.getY())));
        neighbours.add(cells.get(coordinates.getX()).get(getPreviousValue(coordinates.getY())));
        neighbours.add(cells.get(coordinates.getX()).get(getNextValue(coordinates.getY())));
        neighbours.add(cells.get(getNextValue(coordinates.getX())).get(getPreviousValue(coordinates.getY())));
        neighbours.add(cells.get(getNextValue(coordinates.getX())).get(coordinates.getY()));
        neighbours.add(cells.get(getNextValue(coordinates.getX())).get(getNextValue(coordinates.getY())));
        return (int) neighbours.stream().filter(cell -> cell.getStatus() == CellStatus.ALIVE).count();
    }

    private int getPreviousValue(int value) {
        return value == 0 ? cells.size() - 1 : value - 1;
    }

    private int getNextValue(int value) {
        return value == cells.size() - 1 ? 0 : value + 1;
    }

    public void nextGeneration() {
        List<List<Cell>> state = copyCells();
        for (List<Cell> cellList : state) {
            for (Cell cell : cellList) {
                cell.setStatus(gameRules.newStatus(cell.getStatus(), getCellNeighbours(cell.getCoordinates())));
            }
        }
        cells = state;
        generation++;
    }

    private List<List<Cell>> copyCells() {
        List<List<Cell>> result = new ArrayList<>();
        for (List<Cell> cell : cells) {
            List<Cell> newRow = new ArrayList<>();
            for (Cell cell1 : cell) {
                newRow.add(new Cell(
                        cell1.getStatus(),
                        new Coordinates(cell1.getCoordinates().getX(), cell1.getCoordinates().getY())));
            }
            result.add(newRow);
        }
        return result;
    }

    public void applyInitialDisposition(Disposition initialDisposition) {
        if (generation != 1)
            throw new UnsupportedOperationException("Cannot set initial disposition if game already started");
        for (Coordinates coordinate : initialDisposition.getCoordinates()) {
            cells.get(coordinate.getX()).get(coordinate.getY()).setStatus(CellStatus.ALIVE);
        }
    }

    public boolean isEqualTo(Disposition disposition) {
        for (List<Cell> cell : cells) {
            for (Cell cell1 : cell) {
                if ((disposition.getCoordinates().contains(cell1.getCoordinates()) && cell1.getStatus() != CellStatus.ALIVE) ||
                        (!disposition.getCoordinates().contains(cell1.getCoordinates()) && cell1.getStatus() == CellStatus.ALIVE))
                    return false;
            }
        }
        return true;
    }
}
