package com.github.maze;

import java.util.Set;

public class Maze {
    private final Set<Node> nodes;

    public Maze(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getStartNode() {
        for (Node node : nodes) {
            if (node.isStart()) return node;
        }
        return null;
    }

    public Node getEndNode() {
        for (Node node : nodes) {
            if (node.isEnd()) return node;
        }
        return null;
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}
