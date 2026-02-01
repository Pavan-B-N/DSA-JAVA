package BinarySearch.Hard.PaintersPartition;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/painters-partition?category=on-answers&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem


// Time Complexity: O(N * log(sum - max))
// Space Complexity: O(1)
class Solution {
    public int paint(int A, int B, int[] C) {
        // binary search on time = find minTime
        long start = (long) Arrays.stream(C).max().getAsInt() * B;
        long end = 0;
        for (int x : C) {
            end += (long) x * B;
        }

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (countPainters(C, B, mid) > A) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) (start % 10000003);
    }

    private long countPainters(int[] arr, long timePerUnitBoard, long maxTime) {
        long painters = 1;

        long currTime = 0;

        for (int i = 0; i < arr.length; i++) {
            long time = (long) arr[i] * timePerUnitBoard;
            if (currTime + time <= maxTime) {
                currTime += time;
            } else {
                painters++;
                currTime = time;
            }
        }

        return painters;
    }
}

public class PaintersPartition {
    public static void main(String[] args) {

    }
}
