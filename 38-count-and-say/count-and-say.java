class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    cnt++;
                } else {
                    sb.append(cnt).append(s.charAt(j - 1));
                    cnt = 1;
                }
            }
            sb.append(cnt).append(s.charAt(s.length() - 1));
            s = sb.toString();
        }
        return s;
    }
}
