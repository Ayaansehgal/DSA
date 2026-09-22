class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int start = i;

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if (start == i) {
                res.add("" + nums[start]);
            } else {
                res.add(nums[start] + "->" + nums[i]);
            }

            i++;
        }

        return res;
    }
}