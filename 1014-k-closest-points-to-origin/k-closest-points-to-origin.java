import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[2] - a[2]
        );
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            pq.offer(new int[]{x, y, dist});
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }
        return ans;
    }
}