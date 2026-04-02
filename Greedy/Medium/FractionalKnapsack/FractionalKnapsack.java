package Greedy.Medium.FractionalKnapsack;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/fractional-knapsack?category=easy&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N)
// Space Complexity: O(1) sorting by value-to-weight ratio
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.valuePerUnitWeight, a.valuePerUnitWeight));

        for (int i = 0; i < val.length; i++) {
            double valuePerUnitWeight = (double) val[i] / wt[i];
            maxHeap.offer(new Tuple(valuePerUnitWeight, val[i], wt[i]));
        }

        double res = 0;

        while (!maxHeap.isEmpty()) {
            Tuple it = maxHeap.poll();

            if (it.weight <= cap) {
                res += it.value;
                cap -= it.weight;
            } else {
                res += (cap * it.valuePerUnitWeight);
                break;
            }
        }

        return res;
    }

    private class Tuple {
        double valuePerUnitWeight;
        int value;
        int weight;

        public Tuple(double valuePerUnitWeight, int value, int weight) {
            this.valuePerUnitWeight = valuePerUnitWeight;
            this.value = value;
            this.weight = weight;
        }
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {

    }
}
