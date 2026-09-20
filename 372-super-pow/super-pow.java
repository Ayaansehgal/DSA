class Solution {

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {

        a %= MOD;

        int result = 1;

        for (int digit : b) {

            result = modPow(result, 10);
            result = (result * modPow(a, digit)) % MOD;
        }

        return result;
    }

    private int modPow(int a, int n) {

        int result = 1;

        while (n > 0) {

            if (n % 2 == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            n /= 2;
        }

        return result;
    }
}