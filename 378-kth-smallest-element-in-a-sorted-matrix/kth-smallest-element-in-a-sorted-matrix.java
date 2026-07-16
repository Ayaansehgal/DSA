class Solution {
    public int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int i = 0, j = 0, k = 0;
        int[] res = new int[n + m];

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < n) {
            res[k++] = a[i++];
        }

        while (j < m) {
            res[k++] = b[j++];
        }

        return res;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] ans = matrix[0];

        for (int i = 1; i < matrix.length; i++) {
            ans = merge(ans, matrix[i]);
        }

        return ans[k - 1];
    }
}