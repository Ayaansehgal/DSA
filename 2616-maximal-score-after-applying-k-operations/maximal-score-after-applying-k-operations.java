class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        long score = 0;
        while (k-- > 0) {
            int cur = pq.poll();
            score += cur;
            pq.offer((cur + 2) / 3);
        }
        return score;
    }
}