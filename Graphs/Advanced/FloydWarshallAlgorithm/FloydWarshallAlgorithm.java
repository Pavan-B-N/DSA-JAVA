package Graphs.Advanced.FloydWarshallAlgorithm;
// https://takeuforward.org/practice/dsa/floyd-warshall-algorithm?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V^3)
// Space Complexity: O(V^2) for adjacency distance matrix
class Solution {
    public void shortestDistance(int[][] matrix) {

        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue;

                    if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }
}

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {

    }
}
