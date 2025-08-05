class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, m = baskets.length;
        boolean[] used = new boolean[m];
        int unplaced = 0;
        for (int f : fruits) {
            boolean placed = false;
            for (int j = 0; j < m; j++) {
                if (!used[j] && baskets[j] >= f) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) unplaced++;
        }
        return unplaced;
    }
}
