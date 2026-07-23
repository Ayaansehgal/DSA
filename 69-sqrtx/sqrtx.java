class Solution {
    public int mySqrt(int x) {
        int low=0,
        high=x;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long val=(long)mid*mid;
            if(val>x){
                high=mid-1;
            }
            else{
                ans=mid;
                low=mid+1;
            }
        }
        return ans;
    }
}