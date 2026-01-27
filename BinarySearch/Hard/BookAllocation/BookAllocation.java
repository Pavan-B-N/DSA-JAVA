package BinarySearch.Hard.BookAllocation;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/book-allocation-problem?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N * log(sum - max))
// Space Complexity: O(1)
class Solution {
    public int findPages(int[] nums, int m) {
        if (m > nums.length)
            return -1;

        // m = number of students
        // maximum number of pages assigned to student should be minimum

        // binary search on pages or sum
        int start = Arrays.stream(nums).max().getAsInt();
        int end = Arrays.stream(nums).sum();

        while (start <= end) {
            // maxPages
            int mid = start + (end - start) / 2;

            if (countStudents(nums, mid) > m) {
                start = mid + 1;
            } else {
                // ans
                end = mid - 1;
            }
        }

        return start;

    }

    private int countStudents(int[] nums, int maxPages) {
        int student = 1;

        int currPages = 0;

        for (int page : nums) {
            if (currPages + page <= maxPages) {
                currPages += page;
            } else {
                currPages = page;
                student++;
            }
        }

        return student;
    }
}

public class BookAllocation {
    public static void main(String[] args) {

    }
}
