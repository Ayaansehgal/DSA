class KthLargest {

    PriorityQueue<Integer> pq;
    int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            if (pq.size() < kth) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public int add(int val) {

        if (pq.size() < kth) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}