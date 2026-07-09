class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int trip[]:trips){
            int pass=trip[0],
            s=trip[1],
            e=trip[2];
            map.put(s,map.getOrDefault(s,0)+pass);
             map.put(e,map.getOrDefault(e,0)-pass);
        }
        int p=0;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
                p+=e.getValue();
                if(p>capacity){
                    return false;
                }
        }
        return true;
    }
}