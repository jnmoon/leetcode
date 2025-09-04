package graph;

import java.util.*;

/**
 * LeetCode 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
 *
 * Approach 1: DFS
 * - Traverse each connected component with recursion.
 * - Mark nodes visited to avoid cycles.
 * Time:  O(n^2)
 * Space: O(n) (visited + recursion stack)
 *
 * Approach 2: BFS
 * - Traverse each connected component with a queue.
 * - Mark nodes visited as they are enqueued.
 * Time:  O(n^2)
 * Space: O(n) (visited + queue)
 */
public class LC0547_NumberOfProvinces {
    public int findCircleNumDFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                result++;
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected, int idx, boolean[] visited) {
        visited[idx] = true;
        for (int i = 0; i < isConnected[idx].length; i++) {
            if (!visited[i] && isConnected[idx][i] == 1) {
                dfs(isConnected, i, visited);
            }
        }
    }

    public int findCircleNumBFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            queue.add(i);
            result++;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 0; j < isConnected[cur].length; j++) {
                    if (!visited[j] && isConnected[cur][j] == 1) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        return result;
    }
}
