package Greedy.Hard.NonOverlappingInterval;
import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/description/
// https://takeuforward.org/practice/dsa/non-overlapping-intervals?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N log N)
// Space Complexity: O(1) greedy selection by end time
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (prevEnd <= intervals[i][0]) {
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}

public class NonOverlappingInterval {
    public static void main(String[] args) {

    }
}
