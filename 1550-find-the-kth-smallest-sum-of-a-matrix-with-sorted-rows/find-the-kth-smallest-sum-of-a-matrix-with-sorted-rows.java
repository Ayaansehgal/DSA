import java.util.*;

class HeapElement {
    int sum;
    int[] indexes;

    HeapElement(int sum, int[] indexes) {
        this.sum = sum;
        this.indexes = indexes;
    }
}

class Solution {
    public int kthSmallest(int[][] mat, int k) {

        PriorityQueue<HeapElement> minHeap =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        Set<String> visited = new HashSet<>();

        int m = mat.length;

        int firstSum = 0;
        int[] start = new int[m];

        for (int i = 0; i < m; i++) {
            firstSum += mat[i][0];
        }

        minHeap.offer(new HeapElement(firstSum, start));
        visited.add(Arrays.toString(start));

        while (--k > 0) {

            HeapElement cur = minHeap.poll();

            for (int r = 0; r < m; r++) {

                int[] next = cur.indexes.clone();

                if (next[r] + 1 >= mat[r].length)
                    continue;

                next[r]++;

                String key = Arrays.toString(next);

                if (visited.contains(key))
                    continue;

                visited.add(key);

                int newSum = cur.sum
                        - mat[r][next[r] - 1]
                        + mat[r][next[r]];

                minHeap.offer(new HeapElement(newSum, next));
            }
        }

        return minHeap.peek().sum;
    }
}