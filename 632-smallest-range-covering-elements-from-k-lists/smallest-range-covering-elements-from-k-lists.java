class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int right = Integer.MIN_VALUE;
        int resLeft = 0, resRight = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            right = Math.max(right, val);
        }

        while (pq.size() == nums.size()) {

            int[] e = pq.poll();

            int left = e[0];
            int listIdx = e[1];
            int eleIdx = e[2];

            if ((right - left) < (resRight - resLeft)
                    || ((right - left) == (resRight - resLeft) && left < resLeft)) {
                resLeft = left;
                resRight = right;
            }

            int newEleIdx = eleIdx + 1;

            if (newEleIdx < nums.get(listIdx).size()) {
                int val = nums.get(listIdx).get(newEleIdx);
                right = Math.max(right, val);
                pq.offer(new int[]{val, listIdx, newEleIdx});
            }
        }

        return new int[]{resLeft, resRight};
    }
}