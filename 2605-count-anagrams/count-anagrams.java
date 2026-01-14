class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100_000;

    long[] fact = new long[MAX + 1];
    long[] invFact = new long[MAX + 1];

    public int countAnagrams(String s) {
        precompute();

        long ans = 1;
        int n = s.length();
        int i = 0;

        while (i < n) {
            int[] freq = new int[26];
            int len = 0;

            while (i < n && s.charAt(i) != ' ') {
                freq[s.charAt(i) - 'a']++;
                len++;
                i++;
            }

            long ways = fact[len];
            for (int f : freq) {
                if (f > 1) {
                    ways = (ways * invFact[f]) % MOD;
                }
            }

            ans = (ans * ways) % MOD;
            i++;
        }

        return (int) ans;
    }

    private void precompute() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = modInverse(fact[i]);
        }
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
