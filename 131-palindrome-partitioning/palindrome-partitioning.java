class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> temp, String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                temp.add(s.substring(start, end + 1));
                backtrack(res, temp, s, end + 1, dp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
