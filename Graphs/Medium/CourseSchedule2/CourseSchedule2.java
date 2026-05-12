package Graphs.Medium.CourseSchedule2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/course-schedule-ii?category=hard-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/course-schedule-ii/

// Time Complexity: O(V + E) - Topological Sort
// Space Complexity: O(V) for in-degree array and result order
class Solution {
    public int[] findOrder(int N, int[][] arr) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build actual graph

        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][1];
            int v = arr[i][0];

            adj.get(u).add(v);
        }

        // apply kahns algo
        int[] indegree = new int[N];

        for (int node = 0; node < N; node++) {
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int node = 0; node < N; node++) {
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }

        int[] topoSort = new int[N];
        int topoIndex = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[topoIndex++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoIndex == N ? topoSort : new int[] {};
    }
}

public class CourseSchedule2 {
    public static void main(String[] args) {

    }
}
