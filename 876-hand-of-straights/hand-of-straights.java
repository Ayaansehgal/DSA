class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for(int i:hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i:map.keySet()){
            int count =map.get(i);
            if(count>0){
                for (int j = 0; j < groupSize; j++) {
                    int cur = i + j;
                    if (map.getOrDefault(cur, 0) < count) return false;
                    map.put(cur, map.get(cur) - count);
                }
            }
        }
        return true;
    }
}