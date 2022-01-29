package com.github.algorithms;

import com.github.maze.Maze;
import com.github.maze.Node;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Algorithm {

    private final Set<GraphHelperNode> nodes;

    protected Algorithm(Maze maze) {
        this.nodes = createHelpers(maze);
    }

    protected abstract void solve();

    protected Set<GraphHelperNode> getNodes() {
        return nodes;
    }

    public GraphHelperNode getStartNode() {
        for (var node : nodes) {
            if (node.getNode().isStart()) return node;
        }
        return null;
    }

    public GraphHelperNode getEndNode() {
        for (var node : nodes) {
            if (node.getNode().isEnd()) return node;
        }
        return null;
    }

    public List<Node> getPath() {
        Deque<GraphHelperNode> path = new LinkedList<>();
        path.addFirst(getEndNode());

        while (!path.getFirst().getNode().isStart()) {
            path.addFirst(path.getFirst().getPreviousNode());
        }
        return path.stream().map(GraphHelperNode::getNode).collect(Collectors.toList());
    }

    private Set<GraphHelperNode> createHelpers(Maze maze) {
        Map<Node, GraphHelperNode> nodes = new HashMap<>();
        for (var node : maze.getNodes()) {
            nodes.put(node, new GraphHelperNode(node));
        }
        for (var node : nodes.keySet()) {
            var dijkstraHelperNode = nodes.get(node);
            var nodeNeighbors = node.getNeighbors();
            dijkstraHelperNode.setNeighbours(nodeNeighbors.stream().map(nodes::get).collect(Collectors.toSet()));
        }
        return new HashSet<>(nodes.values());
    }
}
