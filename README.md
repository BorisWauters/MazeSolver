# Maze solver

A maze solver that takes an image of a maze as input, solves the maze and outputs the solution.

## Input format

The program expects a png image of a maze with the following properties:
* Every cell has a size of 1 pixel.
* Walls are black (r=0, g=0, b=0).
* Path cells are white (r=255, g=255, b=255).
* Start is green (r=0, g=255, b=0).
* End is red (r=0, g=0, b=255).

I used the following link to generate some mazes and then added the start and end points: https://keesiemeijer.github.io/maze-generator/#generate

## Output format

The output is similar to the input maze with the exception that the path is now colored blue(r=0, g=0, b=255).

## Solver

Currently, there are two available algorithms to solve the maze, Dijkstra and DFS.

### Possible future expansions

Implement some more solving algorithms:
* A*
* Bellman Ford
* BFS
