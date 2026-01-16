package BinarySearch.Easy.FindRotation;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/find-out-how-many-times-the-array-is-rotated?category=logic-building&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int peakIndex = findPeak(nums);
        return (peakIndex + 1) % nums.size();
    }

    private int findPeak(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid + 1 < list.size() && list.get(mid) > list.get(mid + 1)) {
                return mid;
            } else if (list.get(start) > list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return list.size() - 1;
    }
}

public class FindRotation {
    public static void main(String[] args) {

    }
}
