class Solution {
    public int findMin(int[] nums) {
        int res=Integer.MAX_VALUE;
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[l]<=nums[mid]){
                res=Math.min(res,nums[l]);
                l=mid+1;
            }
            else{
                res=Math.min(res,nums[mid]);
                r=mid-1;
            }
        }
        return res;
    }
}