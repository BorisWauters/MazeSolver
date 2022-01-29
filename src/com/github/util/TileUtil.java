package com.github.util;

import com.github.maze.Node;
import com.github.maze.Tile;

import java.awt.*;
import java.util.List;


public class TileUtil {

    private TileUtil() {
        // static util class
    }

    public static void addPathToTileMaze(List<Node> path, Tile[][] tileMaze) {
        for (var node : path) {
            Tile tile = tileMaze[node.getX()][node.getY()];
            if (tile == Tile.PATH) {
                tileMaze[node.getX()][node.getY()] = Tile.MARKED;
            }
        }
    }

    public static Color[][] transformToColors(Tile[][] tileMaze) {
        int width = tileMaze.length;
        int height = tileMaze[0].length;

        Color[][] colors = new Color[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                colors[i][j] = tileMaze[i][j].transformToColor();
            }
        }
        return colors;
    }
}
