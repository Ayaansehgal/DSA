class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalcost=0; 
        int totalgas=0;
        int currTank=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
            currTank += gas[i] - cost[i];
            if(currTank<0){
                start=i+1;
                currTank=0;
            }
        }
        return(totalgas<totalcost)?-1:start;
    }
}