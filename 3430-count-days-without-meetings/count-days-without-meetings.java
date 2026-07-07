class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();

        res.add(new int[]{meetings[0][0], meetings[0][1]});

        for (int i = 1; i < meetings.length; i++) {

            int[] last = res.get(res.size() - 1);

            if (meetings[i][0] <= last[1]) {
                last[1] = Math.max(last[1], meetings[i][1]);
            } else {
                res.add(new int[]{meetings[i][0], meetings[i][1]});
            }
        }

        int occupied = 0;

        for (int[] interval : res) {
            occupied += interval[1] - interval[0] + 1;
        }

        return days - occupied;
    }
}