class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int currcount=0;
                while(i<nums.length && nums[i]==1 ){
                    
                    if(nums[i++]==1){
                        currcount++;
                    }
                    
                }
                if(currcount>count){
                    count=currcount;
                }
            }
        }
        return count;
    }
}