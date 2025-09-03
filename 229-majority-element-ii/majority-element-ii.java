class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n=nums.length;
        n=n/3;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>=n){
                if(!res.contains(nums[i])){
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }
}