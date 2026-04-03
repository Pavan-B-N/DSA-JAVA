package Greedy.Medium.MergeIntervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/

// Time Complexity: O(N log N)
// Space Complexity: O(1) auxiliary space excluding result list
class Solution {
    public int[][] merge(int[][] intervals) {
        // sort based on start point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < n && intervals[i + 1][0] <= end) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            list.add(new int[] { start, end });
            i++;
        }

        int[][] res = new int[list.size()][2];

        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }

        return res;

    }
}

public class MergeIntervals {
    public static void main(String[] args) {

    }
}
