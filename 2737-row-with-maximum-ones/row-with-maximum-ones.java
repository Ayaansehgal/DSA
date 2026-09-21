class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int res[]=new int[2];
        int max=0;
        for(int i=0;i<mat.length;i++){
            int sum=Arrays.stream(mat[i]).sum();
            if(sum>max){
                res[0]=i;
                res[1]=sum;
                max=sum;
            }
        }
        return res;
    }
}