class Solution {
    public int su(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        while(fast!=1){
            slow=su(slow);
            fast=su(su(fast));
            if(fast==1){
                return true;
            }
            if(slow==fast){
                return false;
            }
        }
        return true;
    }
}