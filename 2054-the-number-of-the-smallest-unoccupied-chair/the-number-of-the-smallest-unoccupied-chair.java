class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableChair = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChair =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++) {
            availableChair.add(i);
        }
        for (int i = 0; i < times.length; i++) {
            int at = times[i][0];
            while (!occupiedChair.isEmpty() && occupiedChair.peek()[0] <= at) {
                availableChair.add(occupiedChair.poll()[1]);
            }
            int chair = availableChair.poll();
            if (at == targetArrivalTime) {
                return chair;
            }
            occupiedChair.add(new int[]{times[i][1], chair});
        }
        return -1;
    }
}