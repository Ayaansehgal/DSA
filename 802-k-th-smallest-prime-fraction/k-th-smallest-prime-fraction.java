class Prime {
    double fac;
    int i, j;

    public Prime(double fac, int i, int j) {
        this.fac = fac;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<Prime> pq =
            new PriorityQueue<>((a, b) -> Double.compare(a.fac, b.fac));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.offer(new Prime((double) arr[i] / arr[j], i, j));
            }
        }

        while (--k > 0) {
            pq.poll();
        }

        Prime p = pq.poll();

        return new int[]{arr[p.i], arr[p.j]};
    }
}