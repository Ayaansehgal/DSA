class Solution {
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        List<int[]> res=new ArrayList<>();
        int i=0,j=0;
        while(i<f.length && j<s.length){
            int e1=f[i][1],
            e2=s[j][1],
            s1=f[i][0],
            s2=s[j][0];
            if(e1>=s2 && e2>=s1){
                res.add(new int[]{
                    Math.max(s1,s2),
                    Math.min(e1,e2)
                });
            }
            if(e1<e2){
                i++;
            }
            else{
                j++;
            }
        }
        int ans[][]=new int[res.size()][2];
        for(int l=0;l<res.size();l++){
            ans[l]=res.get(l);
        }
        return ans;
    }
}