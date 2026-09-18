class Solution {
    public long sumAndMultiply(int n) {
        int sum =0;
        String cleanedStr = String.valueOf(n).replace("0", "");
        int result = cleanedStr.isEmpty() ? 0 : Integer.parseInt(cleanedStr);
        int temp=result;
        while(temp>0){
            int dig=temp%10;
            sum+=dig;
            temp/=10;
        }
        return (long)sum*result;
    }
}