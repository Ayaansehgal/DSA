class Solution {
    private static boolean check(int arr[],int l,int k){
        long t=0;
        for(int i=0;i<arr.length;i++){
            t+=(arr[i]+l-1)/l;
        }
        return t<=k;
    }

    public int minEatingSpeed(int[] piles, int k) {
        int l=1;
        int h=Arrays.stream(piles).max().getAsInt();
        int res=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            System.out.println("l="+l+" h="+h+" mid="+mid);
            if(check(piles,mid,k)){
                System.out.println("check, res="+mid);
                h=mid-1;
                res=mid;
            }
            else{
                System.out.println("check false");
                l=mid+1;
            }
        }
        return res;
    }
}