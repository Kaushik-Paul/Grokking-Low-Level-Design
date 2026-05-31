package com.example.lowleveldesign.trafficsignalsystem.domain;

import java.util.List;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static List<Direction> getAllDirections() {
        return List.of(NORTH, EAST, SOUTH, WEST);
    }
}
