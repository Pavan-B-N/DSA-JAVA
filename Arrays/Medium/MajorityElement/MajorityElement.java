package Arrays.Medium.MajorityElement;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/description/
// https://takeuforward.org/practice/dsa/majority-element-i

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();//{ele -> freq}
        int n = nums.length;

        for(int i=0;i<n;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> pair:hashMap.entrySet()){
            if(pair.getValue() > n/2){
                return pair.getKey();
            }
        }

        return -1;
    }
}

// Boyer-Moore Majority Voting Algorithm
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Moores {
    public int majorityElement(int[] nums) {
        // moores algorithm
        int freq = 0;
        int ans = -1;

        for(int i=0;i<nums.length;i++){
            if(freq==0){
                ans = nums[i];
            }

            if(ans==nums[i]){
                freq++;
            }else{
                freq--;
            }
        }

        return ans;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        
    }
}
