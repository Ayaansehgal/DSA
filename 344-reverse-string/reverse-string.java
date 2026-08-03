class Solution {
    public void helper(char s[],int st,int e){
        if(st>=e){
            return;
        }
        char t=s[st];
        s[st]=s[e];
        s[e]=t;
        helper(s,st+1,e-1);
    }
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
}