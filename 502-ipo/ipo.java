class pj{
    int c;
    int p;
    public pj(int p,int c){
        this.c=c;
        this.p=p;
    }
}
class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        pj []pjs=new pj[n];
        for(int i=0;i<n;i++){
            pjs[i]=new pj(profits[i],capital[i]);
        }
        Arrays.sort(pjs,(a,b)->a.c-b.c);
        PriorityQueue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        for(int i=0;i<k;i++){
            while(idx<n && w>=pjs[idx].c){
                max.add(pjs[idx].p);
                idx++;
            }
            if(max.size()==0){
                return w;
            }
            w+=max.poll();
        }
        return w;
    }
}