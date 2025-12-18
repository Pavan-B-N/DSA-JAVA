package Arrays.Hard.FindRepeatingAndMissingNumber;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/find-the-repeating-and-missing-number?category=faqs-hard&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution_Hashing {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // { ele -> freq}

        for (int ele : nums) {
            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);
        }

        int A = -1; // RepeatingNumber
        int B = -1; // MissingNumber

        for (int i = 1; i <= nums.length; i++) {
            if (!hashMap.containsKey(i)) {
                B = i;
            } else if (hashMap.get(i) == 2) {
                A = i;
            }
        }

        return new int[] { A, B };
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// Constraints mentions that we are not allowed to sort the array so this
// approch violates it
class Solution_CyclicSort {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        // cyclic sort
        for (int i = 0; i < n; i++) {
            while (nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) {
                return new int[] { nums[i], i + 1 };
            }
        }

        return new int[] { -1, -1 };
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_Math {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        long SN = ((long) n * (n + 1)) / 2;
        long S2N = ((long) n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0;
        long S2 = 0;

        for (int i = 0; i < nums.length; i++) {
            S += nums[i];
            S2 += ((long) nums[i] * nums[i]);
        }

        long num1 = (SN - S);
        long num2 = S2N - S2;
        long num3 = num2 / num1;

        int B = (int) ((num1 + num3) / 2);
        int A = (int) (num3 - B);

        return new int[] { A, B };
    }
}

public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {

    }
}
