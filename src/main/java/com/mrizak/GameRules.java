package com.mrizak;

public interface GameRules {
    CellStatus newStatus(CellStatus current, int neighbours);
}
