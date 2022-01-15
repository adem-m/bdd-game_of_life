package com.mrizak;

public final class Cell {
    private CellStatus status;
    private final Coordinates coordinates;

    public Cell(CellStatus status, Coordinates coordinates) {
        this.status = status;
        this.coordinates = coordinates;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public CellStatus getStatus() {
        return status;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
