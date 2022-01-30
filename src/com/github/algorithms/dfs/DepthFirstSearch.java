package com.github.algorithms.dfs;

import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;
import com.github.maze.Maze;

import java.util.*;

public class DepthFirstSearch extends Algorithm {

    private final Set<GraphHelperNode> visitedNodes;

    public DepthFirstSearch(Maze maze) {
        super(maze);
        this.visitedNodes = new HashSet<>();
    }

    @Override
    public void solve() {
        Deque<GraphHelperNode> stack = new ArrayDeque<>();
        GraphHelperNode startNode = getStartNode();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node.getNode().isEnd()) return;

            for (var neighbour : node.getNeighbours()) {
                if (visitedNodes.contains(neighbour)) continue;
                visitedNodes.add(neighbour);
                neighbour.setPreviousNode(node);
                stack.push(neighbour);
            }
        }
    }
}
