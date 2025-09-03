class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        res[0]=findfirst(nums,target);
        res[1]=findlast(nums,target);
        return res;
    }
    private int findlast(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int i=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                i= mid;
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return i;
    }
    private int findfirst(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int i=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                i= mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return i;
    }
}