class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate(res,"",n,n);
        return res;
    }
    public static void generate(List<String> res,String curr,int open,int closed){
        if(closed==0 && open==0){
            res.add(curr);
            return;
        }
        if(open>0){
            generate(res,curr+'(',open-1,closed);
        }
        if(closed>open){
            generate(res,curr+')',open,closed-1);
        }
    }
}