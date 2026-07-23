class Solution {
    static final long MOD = 1_000_000_007L;

    class Pair {
        long val;
        int idx;

        Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        if (multiplier == 1)
            return nums;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val)
                return a.idx - b.idx;
            return Long.compare(a.val, b.val);
        });

        long mx = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i], i));
            mx = Math.max(mx, nums[i]);
        }
        while (k > 0 && pq.peek().val < mx) {
            Pair cur = pq.poll();
            cur.val *= multiplier;
            pq.offer(cur);
            k--;
        }
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = pq.poll();
        Arrays.sort(arr, (a, b) -> {
            if (a.val == b.val)
                return a.idx - b.idx;
            return Long.compare(a.val, b.val);
        });

        long each = k / n;
        int extra = k % n;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            long times = each + (i < extra ? 1 : 0);
            long value = arr[i].val % MOD;
            value = value * modPow(multiplier, times) % MOD;
            ans[arr[i].idx] = (int) value;
        }

        return ans;
    }
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}