package com.github.algorithms.dijkstra;

import com.github.maze.Maze;
import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra extends Algorithm {

    public Dijkstra(Maze maze) {
        super(maze);
    }

    @Override
    public void solve() {
        PriorityQueue<GraphHelperNode> queue = new PriorityQueue<>(getNodes().size());
        Set<GraphHelperNode> vertices = new HashSet<>(getNodes());

        GraphHelperNode startNode = getStartNode();
        startNode.setShortestPathLength(0);
        queue.add(startNode);

        while (!vertices.isEmpty()) {
            var currentNode = queue.poll();
            vertices.remove(currentNode);

            if (currentNode.getNode().isEnd()) {
                System.out.println("End reached with path length " + currentNode.getShortestPathLength());
                return;
            }

            for (var neighbour : currentNode.getNeighbours()) {
                int distance = currentNode.getShortestPathLength() + currentNode.getDistanceTo(neighbour);
                if (distance < neighbour.getShortestPathLength()) {
                    queue.remove(neighbour);
                    neighbour.setShortestPathLength(distance);
                    neighbour.setPreviousNode(currentNode);
                    queue.add(neighbour);
                }
            }
        }
    }
}
