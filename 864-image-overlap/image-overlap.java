class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int max = 0;

        // Shift img1 vertically
        for (int dx = -(n - 1); dx <= n - 1; dx++) {

            for (int dy = -(n - 1); dy <= n - 1; dy++) {

                int overlap = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int x = i + dx;
                        int y = j + dy;

                        if (x >= 0 && x < n && y >= 0 && y < n) {

                            if (img1[i][j] == 1 && img2[x][y] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                max = Math.max(max, overlap);
            }
        }

        return max;
    }
}