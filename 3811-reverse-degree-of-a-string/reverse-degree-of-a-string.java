class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int value=27 - (s.charAt(i) - 'a' + 1);
            sum+=(i+1)*(value);
        }
        return sum;
    }
}