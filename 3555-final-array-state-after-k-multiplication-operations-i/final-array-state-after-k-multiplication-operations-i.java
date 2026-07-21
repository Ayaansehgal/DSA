class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val)
                return a.idx - b.idx;
            return a.val - b.val;
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
        }

        while (k-- > 0) {
            Pair cur = pq.poll();

            cur.val *= multiplier;
            nums[cur.idx] = cur.val;

            pq.offer(cur);
        }

        return nums;
    }
}