class Solution {

    static String rev(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            i++;
            j--;
        }

        return new String(arr);
    }

    public String reverseWords(String s) {

        String arr[] = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rev(arr[i]);
        }

        return String.join(" ", arr);
    }
}