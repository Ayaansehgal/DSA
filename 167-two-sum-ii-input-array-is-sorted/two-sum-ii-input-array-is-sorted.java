class Solution {
    public int[] twoSum(int[] n, int target) {
        int i=0,j=n.length-1;
        while(i<=j){
            if(n[i]+n[j]==target){
                return new int[]{
                    i+1,j+1
                };
            }
            else if(n[i]+n[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        
        return new int[]{
            -1,-1
        };
    }
}