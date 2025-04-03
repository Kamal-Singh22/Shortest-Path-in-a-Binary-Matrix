# Shortest-Path-in-a-Binary-Matrix
You are given an n x n binary matrix grid. Your task is to find the length of the shortest clear path from the top-left cell (0,0) to the bottom-right cell (n-1,n-1). 
Explanation
BFS Traversal:

We use a queue to explore all possible paths level by level.

Each step adds 1 to the path length.

The first time we reach (n-1, n-1), we return the path length.

Valid Move Checking:

A move is valid if it's within the bounds of the grid and the cell is 0 (walkable).

The cell is marked as 1 to prevent revisiting.

Time Complexity:

O(n²), as we explore each cell at most once.

Space Complexity:

O(n²) in the worst case due to the queue.
