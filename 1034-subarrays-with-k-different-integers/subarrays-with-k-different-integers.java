import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    private int helper(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) == 1) {
                k--; 
            }
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    k++; 
                }
                left++;
            }

            res += i - left + 1; 
        }
        return res;
    }
}
