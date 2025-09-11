class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) > 2) {
                return false; // any number occurs more than 2 times
            }
        }
        return true;
    }
}
