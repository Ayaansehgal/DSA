class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        TreeMap<Integer, Integer> set = new TreeMap<>();
        int[] res = new int[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < res.length; i++) {

            int count = 0;

            for (int val : set.keySet()) {
                count += set.get(val);

                if (count >= x) {
                    res[i] = Math.min(val, 0);
                    break;
                }
            }

            int remove = nums[i];
            set.put(remove, set.get(remove) - 1);

            if (set.get(remove) == 0) {
                set.remove(remove);
            }

            if (i + k < nums.length) {
                int add = nums[i + k];
                set.put(add, set.getOrDefault(add, 0) + 1);
            }
        }

        return res;
    }
}