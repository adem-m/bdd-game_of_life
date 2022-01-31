package com.mrizak;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (status != cell.status) return false;
        return Objects.equals(coordinates, cell.coordinates);
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }
}
