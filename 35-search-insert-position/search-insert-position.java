class Solution {
    public int searchInsert(int[] nums, int target) {
        if(search(nums,target)==-1){
            int i=0;
            while(i<nums.length && nums[i]<target){
                i++;
            }
            return i;
        }
        return search(nums,target);
    }
    private int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}