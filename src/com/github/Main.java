package com.github;

import com.github.algorithms.dijkstra.Dijkstra;
import com.github.maze.Maze;
import com.github.maze.Node;
import com.github.maze.Tile;
import com.github.util.ImageUtil;
import com.github.util.MazeUtil;
import com.github.util.TileUtil;

import java.awt.*;
import java.util.List;


public class Main {

    private static String fileName = "maze-3.png";

    public static void main(String[] args) {
        if (args.length > 0) {
            fileName = args[0];
        }

        Color[][] colors = ImageUtil.loadImage("input/" + fileName);
        Tile[][] tiles = MazeUtil.transformToTileMaze(colors);
        Maze maze = MazeUtil.transformToMaze(tiles);

        Dijkstra dijkstra = new Dijkstra(maze);
        dijkstra.solve();
        List<Node> path = dijkstra.getPath();

        TileUtil.addPathToTileMaze(path, tiles);
        colors = TileUtil.transformToColors(tiles);
        ImageUtil.writeImage(colors, "output/" + fileName);
    }
}
