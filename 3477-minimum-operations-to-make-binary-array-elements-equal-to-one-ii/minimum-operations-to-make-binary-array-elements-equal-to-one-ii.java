class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        boolean flipped = false;

        for (int num : nums) {
            int current = flipped ? 1 - num : num;

            if (current == 0) {
                operations++;
                flipped = !flipped;
            }
        }

        return operations;
    }
}