class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;

    public boolean solve(int index, int jump, int[] stones) {

        if (index == stones.length - 1)
            return true;

        if (dp[index][jump] != null)
            return dp[index][jump];

        for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {

            if (nextJump <= 0)
                continue;

            int nextPos = stones[index] + nextJump;

            if (map.containsKey(nextPos)) {

                if (solve(map.get(nextPos), nextJump, stones))
                    return dp[index][jump] = true;
            }
        }

        return dp[index][jump] = false;
    }

    public boolean canCross(int[] stones) {

        int n = stones.length;

        if (stones[1] != 1)
            return false;

        for (int i = 0; i < n; i++)
            map.put(stones[i], i);

        dp = new Boolean[n][n + 1];

        return solve(1, 1, stones);
    }
}