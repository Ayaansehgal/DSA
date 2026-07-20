class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.val == b.val)
                    return a.idx - b.idx;
                return a.val - b.val;
            });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));

            if (pq.size() > k)
                pq.poll();
        }
        List<Pair> list = new ArrayList<>();
        while (!pq.isEmpty())
            list.add(pq.poll());
        Collections.sort(list, (a, b) -> a.idx - b.idx);
        int[] ans = new int[k];

        for (int i = 0; i < k; i++)
            ans[i] = list.get(i).val;

        return ans;
    }
}