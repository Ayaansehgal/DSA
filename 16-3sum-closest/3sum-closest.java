class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int tempsum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int currentsum=nums[i]+nums[left]+nums[right];
                if(Math.abs(currentsum-target)<Math.abs(tempsum-target)){
                    tempsum=currentsum;
                }
                if(currentsum<target){
                    left++;
                }
                else if(currentsum>target){
                    right--;
                }
                else{
                    return target;
                }
            }

        }
        return tempsum;
    }
}