class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:stones){
            pq.add(x);
        }
        while(pq.size()>1){
            int l=pq.remove();
            int s=pq.remove();
            if(l>s){
                pq.add(l-s);
            }
        }
        if(pq.size()==1){
            return pq.peek();
        }
    return 0;
    }
}