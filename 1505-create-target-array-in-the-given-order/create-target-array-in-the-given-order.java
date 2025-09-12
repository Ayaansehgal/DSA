class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> target = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]); 
        }
        
        int[] result = new int[target.size()];
        int i = 0;
        for (int val : target) {
            result[i++] = val;
        }
        return result;
    }
}
