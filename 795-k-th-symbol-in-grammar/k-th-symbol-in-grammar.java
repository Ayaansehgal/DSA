class Solution {
    public int helper(int n,int k,int f){
        if(n==1){
            return f%2==0?0:1;
        }
        if(k%2==0){
            return helper(n-1,k/2,f+1);
        }
        return helper(n-1,(k+1)/2,f);
    }
    public int kthGrammar(int n, int k) {
        return helper(n,k,0);
    }
}