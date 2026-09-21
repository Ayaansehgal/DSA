class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int best = divisors[0];
        int maxScore = -1;

        for (int d : divisors) {
            int score = 0;

            for (int n : nums) {
                if (n % d == 0) {
                    score++;
                }
            }

            if (score > maxScore || 
                (score == maxScore && d < best)) {
                maxScore = score;
                best = d;
            }
        }

        return best;
    }
}