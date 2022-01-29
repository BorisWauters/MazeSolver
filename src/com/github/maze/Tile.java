package com.github.maze;

import java.awt.*;

public enum Tile {
    WALL(0, 0, 0),
    PATH(255, 255, 255),
    START(0, 255, 0),
    END(255, 0, 0),
    MARKED(0, 0, 255);

    private final int r;
    private final int g;
    private final int b;

    Tile(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public boolean isTile(Color color) {
        return this.r == color.getRed() && this.g == color.getGreen() && this.b == color.getBlue();
    }

    public Color transformToColor() {
        return new Color(r, g, b);
    }

    public static Tile transformToTile(Color color) {
        for (Tile tile : Tile.class.getEnumConstants()) {
            if (tile.isTile(color)) return tile;
        }
        return WALL;
    }
}
