class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[]=new int[256];
        boolean ispresent[]=new boolean[256];
        char[] arr = s.toCharArray();
        for(char c:arr){
            freq[c]++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:arr){
            freq[c]--;
            if(ispresent[c])continue;
             while (!stack.isEmpty() && stack.peekLast() > c && freq[stack.peekLast()] > 0){
                char removed = stack.pollLast();
                ispresent[removed] = false;
                
            }
            stack.addLast(c);
            ispresent[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}