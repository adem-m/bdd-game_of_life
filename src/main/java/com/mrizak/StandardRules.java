package com.mrizak;

public class StandardRules implements GameRules {

    @Override
    public CellStatus newStatus(CellStatus current, int neighbours) {
        if (current == CellStatus.DEAD && neighbours == 3) return CellStatus.ALIVE;
        if (current == CellStatus.ALIVE) {
            if (neighbours < 2 || neighbours > 3) return CellStatus.DEAD;
            return CellStatus.ALIVE;
        }
        return current;
    }
}
