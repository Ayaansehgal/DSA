class Solution {
    public String reverseWords(String s) {
        int i=0;
        String t=s.trim();
        String arr[]=t.split("\\s+");
        int j=arr.length-1;
        while(i<j){
            String temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",arr);
    }
}