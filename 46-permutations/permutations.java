class Solution {
    private void recper(int nums[],List<List<Integer>> ans,List<Integer> helper,boolean freq[]){
        if(helper.size()==nums.length){
            ans.add(new ArrayList<>(helper));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                helper.add(nums[i]);
                recper(nums,ans,helper,freq);
                helper.remove(helper.size()-1);
                freq[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> helper=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        recper(nums,ans,helper,freq);
        return ans;
    }
}