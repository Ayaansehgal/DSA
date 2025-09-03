class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int i=0;
        while(true){
            if(i+1<nums.length && nums[i]==nums[i+1]){
                i+=2;
            }
            else{
                res=nums[i];
                break;
            }
        }
        return res;
    }
}