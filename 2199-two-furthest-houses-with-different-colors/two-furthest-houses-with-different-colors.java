class Solution {
    public int maxDistance(int[] n) {
        int max=0;
        for(int i=0;i<n.length;i++){
            for(int j=i+1;j<n.length;j++){
                if(n[i]!=n[j]){
                    max=Math.max(max,(j-i));
                }

            }
        }
        return max;
    }
}