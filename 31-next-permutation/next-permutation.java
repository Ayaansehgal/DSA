class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            rev(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }
        rev(nums,index+1,n-1);
    }
    private static void rev(int arr[],int l,int r){
        while(l<r){
            swap(arr,l++,r--);
        }
    }
    private static void swap(int arr[],int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}