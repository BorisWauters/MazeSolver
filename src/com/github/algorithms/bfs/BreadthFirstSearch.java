package com.github.algorithms.bfs;

import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;
import com.github.maze.Maze;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch extends Algorithm {

    public BreadthFirstSearch(Maze maze) {
        super(maze);
    }

    @Override
    public void solve() {
        Queue<GraphHelperNode> queue = new ArrayDeque<>();
        Set<GraphHelperNode> visitedNodes = new HashSet<>();
        queue.add(getStartNode());

        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.isEnd()) return;

            for (var neighbour : node.getNeighbours()) {
                if (visitedNodes.contains(neighbour)) continue;
                visitedNodes.add(neighbour);
                neighbour.setPreviousNode(node);
                queue.add(neighbour);
            }
        }
    }
}
