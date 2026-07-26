import java.util.*;

class Pair {
    int val;
    int diff;

    public Pair(int v, int d) {
        this.val = v;
        this.diff = d;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff) {
                return b.diff - a.diff; 
            }
            return b.val - a.val; 
        });
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Pair(arr[i], Math.abs(arr[i] - x)));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().val);
        }
        Collections.sort(res);
        return res;
    }
}