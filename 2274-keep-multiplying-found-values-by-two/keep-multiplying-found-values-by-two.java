class Solution {
    public int findFinalValue(int[] nums, int original) {
        List<Integer> temp = new ArrayList<>();
        for(int i:nums){
            temp.add(i);
        }
        while(true){
            if(temp.contains(original)){
                original*=2;
            }
            else{
                break;
            }
        }
        return original;
    }
}