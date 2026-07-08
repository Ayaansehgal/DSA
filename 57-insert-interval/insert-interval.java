class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        int i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < intervals.length && ni[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= ni[1]) {
            ni[0] = Math.min(ni[0], intervals[i][0]);
            ni[1] = Math.max(ni[1], intervals[i][1]);
            i++;
        }

        res.add(ni);

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}