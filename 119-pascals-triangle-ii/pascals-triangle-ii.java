class Solution {
    Map<String,Integer> map=new HashMap<>();
    public int helper(int r,int c){
        if(r==0 || c==0 || r==c){
            return 1;
        }
        String key=Integer.toString(r)+Integer.toString(c);
        if(map.containsKey(key)){
            return map.get(key);
        }
        int res=helper(r-1,c-1)+helper(r-1,c);
        map.put(key,res);
        return map.get(key);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res= new ArrayList<>();
        int row=rowIndex;
        for(int i=0;i<=rowIndex;i++){
            res.add(helper(row,i));
        }
        return res;
    }
}