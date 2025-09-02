class Solution {
    public String reverseVowels(String s) {
        int l=0;
        int r=s.length()-1;
        char[] arr = s.toCharArray();
        while(l<r){
            while(l<r && !isVowel(arr[l])){
                l++;
            }
            while(l<r && !isVowel(arr[r])){
                r--;
            }
            if(l<r){
                char temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }
    private Boolean isVowel(char s){
        return "aeiouAEIOU".indexOf(s)!=-1;
    }
}