package Greedy.Medium.InsertInterval;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/description/
// https://takeuforward.org/practice/dsa/insert-interval?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) auxiliary space excluding result list
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // overlapping
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        list.add(newInterval);

        while (i < n) {

            list.add(intervals[i]);
            i++;
        }

        int[][] res = new int[list.size()][2];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;

    }
}

public class InsertInterval {
    public static void main(String[] args) {

    }
}
