package com.mrizak;

import java.util.ArrayList;
import java.util.List;

public final class InitialDisposition {
    public final static InitialDisposition EMPTY_MAP = new InitialDisposition(new ArrayList<>());

    private final List<Coordinates> coordinates;

    public InitialDisposition(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
}
