package com.github.algorithms.dijkstra;

import com.github.algorithms.Algorithm;
import com.github.algorithms.GraphHelperNode;
import com.github.maze.Maze;

import java.util.PriorityQueue;

public class Dijkstra extends Algorithm {

    public Dijkstra(Maze maze) {
        super(maze);
    }

    @Override
    public void solve() {
        PriorityQueue<GraphHelperNode> queue = new PriorityQueue<>(getNodes().size());
        GraphHelperNode startNode = getStartNode();
        startNode.setShortestPathLength(0);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();

            if (currentNode.isEnd()) {
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

        System.out.println("End was not reached");
    }
}
