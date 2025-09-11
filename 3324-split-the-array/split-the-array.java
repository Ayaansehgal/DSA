class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101]; 
        for (int x : nums) {
            freq[x]++;
            if (freq[x] > 2) {
                return false; 
            }
        }
        return true;
    }
}
