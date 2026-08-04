class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int expected = nums[0];
        for (int num : nums) {
            if (num == expected) {
                expected++;
            } else if (num > expected) {
                while (expected < num) {
                    res.add(expected);
                    expected++;
                }
                expected++;
            }
        }
        while (expected <= nums.length) {
            res.add(expected);
            expected++;
        }
        return res;
    }
}