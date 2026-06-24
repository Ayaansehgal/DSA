class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int n=nums.length;
        max=sum;
        for(int i=k;i<n;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            max=Math.max(max,sum);
        }
        return (double)max/k;
    }
}