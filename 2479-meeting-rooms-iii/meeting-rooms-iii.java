class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        long[] endTimeOfRooms = new long[n];
        int[] count = new int[n];
        for (int i = 0; i < meetings.length; i++) {
            int st = meetings[i][0];
            int et = meetings[i][1];
            int min = 0;
            boolean isRoomAllocated = false;
            for (int room = 0; room < n; room++) {
                if (st >= endTimeOfRooms[room]) {
                    endTimeOfRooms[room] = et;
                    count[room]++;
                    isRoomAllocated = true;
                    break;
                }
                if (endTimeOfRooms[room] < endTimeOfRooms[min]) {
                    min = room;
                }
            }
            if (!isRoomAllocated) {
                endTimeOfRooms[min] += (et - st);
                count[min]++;
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }
        return res;
    }
}