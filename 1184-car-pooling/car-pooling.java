class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Map<Integer,Integer> map=new TreeMap<>();
        int buckets[]=new int[1001];
        for(int trip[]:trips){
            int pass=trip[0],
            s=trip[1],
            e=trip[2];
            //map.put(s,map.getOrDefault(s,0)+pass);
             //map.put(e,map.getOrDefault(e,0)-pass);
            buckets[s]=buckets[s]+pass;
            buckets[e]-=pass;
        }
        int p=0;
        for(int b:buckets){
            p+=b;
            if(p>capacity){
                return false;
            }
        }
        return true;
    }
}