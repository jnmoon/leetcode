package graph;

import java.util.*;

/**
 * LeetCode 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * Approach 1: DFS
 * - Use recursion to traverse rooms with keys.
 * - Mark visited rooms to avoid revisits.
 * 
 * Time: O(n + e), where n = number of rooms, e = total number of keys
 * Space: O(n) recursion stack
 *
 * Approach 2: BFS
 * - Use a queue to track accessible rooms
 * - Traverse rooms until all possible rooms are visited.
 *
 * Time: O(n + e)
 * Space: O(n) for visited array + queue
 */
public class LC0841_KeysAndRooms {
    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int idx, boolean[] visited) {
        if (visited[idx]) return;
        visited[idx] = true;
        for (int key : rooms.get(idx)) {
            dfs(rooms, key, visited);
        }
    }

    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>(rooms.get(0));

        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (visited[room]) continue;

            visited[room] = true;
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    queue.add(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
