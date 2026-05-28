package Graphs.Advanced.FindCityWithSmallestNumberOfNeighbors;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/find-the-city-with-the-smallest-number-of-neighbors?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V^3) using Floyd-Warshall or O(V * E log V) using Dijkstra
// Space Complexity: O(V^2) for distance matrix
class Solution {
    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] adjMat = new int[n][n];
        for (int[] row : adjMat)
            Arrays.fill(row, (int) 1e9);

        for (int[] it : edges) {
            adjMat[it[0]][it[1]] = it[2];
            adjMat[it[1]][it[0]] = it[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }

        int minCount = (int) 1e9;

        int ans = -1;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (i != j && adjMat[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count < minCount) {
                minCount = count;

                ans = i;
            } else if (count == minCount) {

                ans = i;
            }
        }

        return ans;
    }
}

public class FindCityWithSmallestNumberOfNeighbors {
    public static void main(String[] args) {

    }
}
