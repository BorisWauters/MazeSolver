package com.github.algorithms.bfs;

import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;
import com.github.maze.Maze;

import java.util.*;

public class BreadthFirstSearch extends Algorithm {
    private final Set<GraphHelperNode> visitedNodes;

    public BreadthFirstSearch(Maze maze) {
        super(maze);
        this.visitedNodes = new HashSet<>();
    }

    @Override
    public void solve() {
        Queue<GraphHelperNode> queue = new ArrayDeque<>();
        GraphHelperNode startNode = getStartNode();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.getNode().isEnd()) return;

            for (var neighbour : node.getNeighbours()) {
                if (visitedNodes.contains(neighbour)) continue;
                visitedNodes.add(neighbour);
                neighbour.setPreviousNode(node);
                queue.add(neighbour);
            }
        }
    }
}
