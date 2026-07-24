class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;
        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;
        for (int val : nums) {
            boolean[][] next = new boolean[4][MAX];
            for (int c = 0; c <= 3; c++) {
                System.arraycopy(dp[c], 0, next[c], 0, MAX);
            }
            for (int rep = 0; rep < 3; rep++) {
                for (int cnt = 2; cnt >= 0; cnt--) {
                    for (int xr = 0; xr < MAX; xr++) {
                        if (next[cnt][xr]) {
                            next[cnt + 1][xr ^ val] = true;
                        }
                    }
                }
            }

            dp = next;
        }
        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }
        return ans;
    }
}