import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    // Directions for moving in 8 possible ways (left, right, up, down, and diagonals)
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},         {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If the start or end cell is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // BFS queue to store {row, col, currentPathLength}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // Mark the cell as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], pathLength = current[2];

            // If we reach the bottom-right cell, return the path length
            if (row == n - 1 && col == n - 1) {
                return pathLength;
            }

            // Explore all 8 possible directions
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (isValidMove(newRow, newCol, grid, n)) {
                    queue.offer(new int[]{newRow, newCol, pathLength + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }

        return -1; // No valid path found
    }

    private static boolean isValidMove(int row, int col, int[][] grid, int n) {
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {0, 1},
            {1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid1)); // Output: 2

        int[][] grid2 = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid2)); // Output: 4

        int[][] grid3 = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid3)); // Output: -1
    }
}
