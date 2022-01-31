package com.github.algorithms;

import com.github.maze.Node;

import java.util.HashSet;
import java.util.Set;

public class GraphHelperNode implements Comparable<GraphHelperNode> {
    private final Node node;
    private Set<GraphHelperNode> neighbours;
    private int shortestPathLength;
    private GraphHelperNode previousNode;

    public GraphHelperNode(Node node) {
        this.node = node;
        this.neighbours = new HashSet<>();
        this.shortestPathLength = Integer.MAX_VALUE;
        this.previousNode = null;
    }

    @Override
    public int compareTo(GraphHelperNode o) {
        return Integer.compare(this.getShortestPathLength(), o.getShortestPathLength());
    }

    public boolean isStart() {
        return this.node.isStart();
    }

    public boolean isEnd() {
        return this.node.isEnd();
    }

    public Node getNode() {
        return node;
    }

    public int getShortestPathLength() {
        return shortestPathLength;
    }

    public void setShortestPathLength(int shortestPathLength) {
        this.shortestPathLength = shortestPathLength;
    }

    public GraphHelperNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(GraphHelperNode previousNode) {
        this.previousNode = previousNode;
    }

    public Set<GraphHelperNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Set<GraphHelperNode> neighbours) {
        this.neighbours = neighbours;
    }

    public int getDistanceTo(GraphHelperNode dijkstraHelperNode) {
        int xDist = Math.abs(node.getX() - dijkstraHelperNode.getNode().getX());
        int yDist = Math.abs(node.getY() - dijkstraHelperNode.getNode().getY());
        return xDist + yDist;
    }
}

