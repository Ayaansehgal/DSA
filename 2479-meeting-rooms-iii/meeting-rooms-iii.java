class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();

        PriorityQueue<long[]> occupied = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[0], b[0]);
            });

        for (int i = 0; i < n; i++)
            available.offer(i);

        int[] count = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while (!occupied.isEmpty() && occupied.peek()[0] <= start) {
                available.offer((int) occupied.poll()[1]);
            }

            if (!available.isEmpty()) {

                int room = available.poll();
                count[room]++;
                occupied.offer(new long[]{end, room});

            } else {

                long[] earliest = occupied.poll();

                long finishTime = earliest[0];
                int room = (int) earliest[1];

                count[room]++;
                occupied.offer(new long[]{finishTime + duration, room});
            }
        }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}