class Solution {
    public String reverseWords(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        while (j >= 0 && s.charAt(j) == ' ')
            j--;

        StringBuilder sb = new StringBuilder();

        while (i <= j) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
            i++;
        }

        i = 0;
        j = sb.length() - 1;

        while (i < j) {
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, t);
            i++;
            j--;
        }

        int start = 0;
        int end = 0;

        while (start < sb.length()) {

            while (end < sb.length() && sb.charAt(end) != ' ')
                end++;

            int p1 = start;
            int p2 = end - 1;

            while (p1 < p2) {
                char t = sb.charAt(p1);
                sb.setCharAt(p1, sb.charAt(p2));
                sb.setCharAt(p2, t);
                p1++;
                p2--;
            }

            start = end + 1;
            end = start;
        }

        return sb.toString();
    }
}