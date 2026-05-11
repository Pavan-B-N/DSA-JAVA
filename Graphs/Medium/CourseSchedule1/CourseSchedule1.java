package Graphs.Medium.CourseSchedule1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/course-schedule-i?category=hard-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/course-schedule/

// Time Complexity: O(V + E) - Kahn's Algorithm / Cycle Detection
// Space Complexity: O(V) for in-degree array and queue
class Solution {
    public boolean canFinish(int N, int[][] arr) {
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

        int topoLen = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoLen++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoLen == N;
    }
}

public class CourseSchedule1 {
    public static void main(String[] args) {

    }
}
