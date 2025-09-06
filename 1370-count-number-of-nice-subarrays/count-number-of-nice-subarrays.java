class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        int left = 0, count = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) k--;  // odd
            while (k < 0) {
                if (nums[left] % 2 == 1) k++;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
