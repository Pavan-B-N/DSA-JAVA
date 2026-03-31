package Heaps.Hard.TaskScheduler;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/task-scheduler/
// https://takeuforward.org/practice/dsa/task-scheduler?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N)
// Space Complexity: O(1) frequency array of size 26
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0;

        Map<Character, Integer> hashMap = new HashMap<>();// {taskName -> freq}

        for (char task : tasks) {
            hashMap.put(task, hashMap.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, hashMap.get(task));
        }

        int cpuIntervals = (maxFreq - 1) * (n + 1);

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int freq = entry.getValue();
            if (freq == maxFreq)
                cpuIntervals++;
        }

        return Math.max(cpuIntervals, tasks.length);

    }
}

public class TaskScheduler {
    public static void main(String[] args) {

    }
}
