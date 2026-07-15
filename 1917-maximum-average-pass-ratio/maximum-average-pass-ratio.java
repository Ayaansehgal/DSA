class Mark {
    double gain;
    int pass, total;

    public Mark(double gain, int pass, int total) {
        this.gain = gain;
        this.pass = pass;
        this.total = total;
    }
}

class Solution {

    private double gain(int p, int t) {
        return ((double)(p + 1) / (t + 1))
             - ((double)p / t);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<Mark> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));

        for (int[] c : classes) {
            pq.offer(new Mark(gain(c[0], c[1]), c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            Mark cur = pq.poll();

            cur.pass++;
            cur.total++;
            cur.gain = gain(cur.pass, cur.total);

            pq.offer(cur);
        }

        double ans = 0;

        while (!pq.isEmpty()) {
            Mark cur = pq.poll();
            ans += (double) cur.pass / cur.total;
        }

        return ans / classes.length;
    }
}