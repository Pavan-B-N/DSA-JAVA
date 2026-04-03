package Greedy.Medium.NMeetingsInOneRoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/practice/dsa/n-meetings-in-one-room?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N)
// Space Complexity: O(N) for meeting objects
class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(start[i], end[i]));
        }

        Collections.sort(list, (a, b) -> Integer.compare(a.end, b.end));

        int prevEnd = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Pair pr = list.get(i);

            if (pr.start > prevEnd) {
                prevEnd = pr.end;
                count++;
            }
        }

        return count;

    }

    class Pair {
        int start;
        int end;

        public Pair(int s, int e) {
            start = s;
            end = e;
        }
    }
}

public class NMeetingsInOneRoom {
    public static void main(String[] args) {

    }
}
