class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int currsum=nums[i];
            if(nums[i]==k){
                count++;
            }
            for(int j=i+1;j<n;j++){
                currsum+=nums[j];
                if(currsum==k){
                    count++;
                }
                
            }
        }
        return count;
    }
}