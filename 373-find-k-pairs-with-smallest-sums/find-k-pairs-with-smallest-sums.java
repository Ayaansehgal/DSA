class Pair {
    int sum, i, j;

    Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new Pair(nums1[i] + nums2[0], i, 0));
        }

        while (k-- > 0 && !pq.isEmpty()) {

            Pair cur = pq.poll();

            ans.add(Arrays.asList(nums1[cur.i], nums2[cur.j]));

            if (cur.j + 1 < nums2.length) {
                pq.offer(new Pair(
                        nums1[cur.i] + nums2[cur.j + 1],
                        cur.i,
                        cur.j + 1));
            }
        }

        return ans;
    }
}