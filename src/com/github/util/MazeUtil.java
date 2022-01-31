package com.github.util;

import com.github.maze.Maze;
import com.github.maze.Node;
import com.github.maze.Tile;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class MazeUtil {

    private MazeUtil() {
        // static util class
    }

    public static Tile[][] transformToTileMaze(Color[][] color) {
        int width = color.length;
        int height = color[0].length;

        Tile[][] tiles = new Tile[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = Tile.transformToTile(color[i][j]);
            }
        }
        return tiles;
    }

    public static Maze transformToMaze(Tile[][] tiles) {
        int width = tiles.length;
        int height = tiles[0].length;
        Node[][] nodes = new Node[width][height];
        Set<Node> connectedNodes = new HashSet<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = tiles[i][j];
                if (tile != Tile.WALL) {
                    nodes[i][j] = new Node(i, j, tile == Tile.START, tile == Tile.END);
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (nodes[i][j] != null) {
                    addNeighbours(nodes[i][j], nodes);
                    connectedNodes.add(nodes[i][j]);
                }
            }
        }
        return new Maze(connectedNodes);
    }

    private static void addNeighbours(Node node, Node[][] nodes) {
        int x = node.getX();
        int y = node.getY();
        int width = nodes.length;
        int height = nodes[0].length;

        if (x != 0 && nodes[x-1][y] != null) {
            node.getNeighbors().add(nodes[x-1][y]);
        }
        if (y != 0 && nodes[x][y-1] != null) {
            node.getNeighbors().add(nodes[x][y-1]);
        }
        if (x < width-1 && nodes[x+1][y] != null) {
            node.getNeighbors().add(nodes[x+1][y]);
        }
        if (y < height-1 && nodes[x][y+1] != null) {
            node.getNeighbors().add(nodes[x][y+1]);
        }
    }
}
