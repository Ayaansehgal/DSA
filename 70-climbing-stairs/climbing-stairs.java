class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int helper(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int res= helper(n-1)+helper(n-2);
            map.put(n,res);
        return map.get(n);
    }
    public int climbStairs(int n) {
        return helper(n);
    }
}