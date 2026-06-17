class Solution {
    void swap(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int i=0,k=0,j=n-1;
        while(k<=j){
            if(nums[k]==1){
                k++;
            }
            else if(nums[k]==2){
                swap(nums,k,j);
                j--;
            }
            else if(nums[k]==0){
                swap(nums,k,i);
                k++;
                i++;
            }
        }
    }
}