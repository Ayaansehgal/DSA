class Solution {
    static boolean check(int[] arr, int k, int m, int days) {
        int bouquets = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) {
                cnt += 1;
            } else {
                bouquets += cnt / k;
                cnt = 0;
            }
        }
        bouquets += cnt / k;
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int l=0,h=Arrays.stream(bloomDay).max().getAsInt();
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(bloomDay,k,m,mid)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;

    }
}