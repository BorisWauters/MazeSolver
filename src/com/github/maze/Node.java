package com.github.maze;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private final int x;
    private final int y;
    private final boolean start;
    private final boolean end;
    private final Set<Node> neighbors;

    public Node(int x, int y, boolean start, boolean end) {
        this.x = x;
        this.y = y;
        this.start = start;
        this.end = end;
        this.neighbors = new HashSet<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isEnd() {
        return end;
    }

    public Set<Node> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
