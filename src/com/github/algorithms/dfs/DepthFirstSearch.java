package com.github.algorithms.dfs;

import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;
import com.github.maze.Maze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch extends Algorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
    }

    @Override
    public void solve() {
        Deque<GraphHelperNode> stack = new ArrayDeque<>();
        Set<GraphHelperNode> visitedNodes = new HashSet<>();
        stack.push(getStartNode());

        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node.isEnd()) return;

            for (var neighbour : node.getNeighbours()) {
                if (visitedNodes.contains(neighbour)) continue;
                visitedNodes.add(neighbour);
                neighbour.setPreviousNode(node);
                stack.push(neighbour);
            }
        }
    }
}
