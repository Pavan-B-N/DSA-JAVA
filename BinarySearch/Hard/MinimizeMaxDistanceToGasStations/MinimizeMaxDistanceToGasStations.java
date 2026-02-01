package BinarySearch.Hard.MinimizeMaxDistanceToGasStations;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/minimise-max-distance-to-gas-stations?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=optimal

// Time Complexity: O(N * log(range))
// Space Complexity: O(1)
class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        // maximum distance between gas stations must be minimized

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.dist / b.sector, a.dist / a.sector));

        for (int i = 1; i < arr.length; i++) {
            double dist = (double) arr[i] - arr[i - 1];

            maxHeap.offer(new Pair(dist, 1));
        }

        while (!maxHeap.isEmpty() && k > 0) {
            Pair pr = maxHeap.poll();

            maxHeap.offer(new Pair(pr.dist, pr.sector + 1));

            k--;
        }

        Pair top = maxHeap.poll();
        return top.dist / top.sector;
    }

    class Pair {
        double dist;
        int sector;

        public Pair(double dist, int sector) {
            this.dist = dist;
            this.sector = sector;
        }
    }
}

public class MinimizeMaxDistanceToGasStations {
    public static void main(String[] args) {

    }
}
