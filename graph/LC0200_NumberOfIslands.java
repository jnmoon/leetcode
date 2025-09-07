package graph;

import java.util.*;

/**
 * LeetCode 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Approach
 * - Traverse the grid and use DFS or BFS to find all connected islands.
 * - Mark visited cells to avoid revisits.
 * 
 * DFS: Simple recursive, less memory, but stack overflow risk
 * BFS: Uses queue, more memory, but no stack overflow
 * 
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class LC0200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    bfs(grid, row, col);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length ||
                grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row - 1, col);
    }

    private int[][] DIR = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0], col = point[1];
            for (int[] dir : DIR) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length &&
                        grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }
}
