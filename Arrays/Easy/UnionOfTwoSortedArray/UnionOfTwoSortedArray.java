package Arrays.Easy.UnionOfTwoSortedArray;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/union-of-two-sorted-arrays

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            int smallestVal = -1;
            if (nums1[i] < nums2[j]) {
                smallestVal = nums1[i++];
            } else {
                smallestVal = nums2[j++];
            }

            if (list.isEmpty() || list.get(list.size() - 1) != smallestVal) {
                list.add(smallestVal);
            }
        }

        while (i < nums1.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < nums2.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }

        int[] res = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {

    }
}
