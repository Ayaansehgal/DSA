class Pair {
    int val;
    int freq;

    public Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        while(k-->0){
            Pair temp=pq.poll();
            int t=temp.freq;
            t--;
            temp.freq=t;
            if(t>0){
                pq.add(temp);
            }
        }
        return pq.size();
    }
}