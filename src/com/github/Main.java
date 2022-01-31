package com.github;

import com.github.algorithms.Algorithm;
import com.github.algorithms.bfs.BreadthFirstSearch;
import com.github.algorithms.dfs.DepthFirstSearch;
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

    private static String fileName = "maze-6.png";

    public static void main(String[] args) {
        if (args.length > 0) {
            fileName = args[0];
        }

        Color[][] colors = ImageUtil.loadImage("input/" + fileName);
        Tile[][] tiles = MazeUtil.transformToTileMaze(colors);
        Maze maze = MazeUtil.transformToMaze(tiles);

        long start = System.currentTimeMillis();

        Algorithm algorithm = new Dijkstra(maze);
        //Algorithm algorithm = new DepthFirstSearch(maze);
        //Algorithm algorithm = new BreadthFirstSearch(maze);
        algorithm.solve();
        List<Node> path = algorithm.getPath();

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Solution found in " + time + "ms");

        TileUtil.addPathToTileMaze(path, tiles);
        colors = TileUtil.transformToColors(tiles);
        ImageUtil.writeImage(colors, "output/" + fileName);
    }
}
