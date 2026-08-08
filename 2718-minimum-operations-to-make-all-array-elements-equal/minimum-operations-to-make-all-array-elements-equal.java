class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {

        List<Long> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int q : queries) {

            int low = 0;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] < q) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            int left = low;

            long leftOperations =
                    (long) q * left - prefix[left];

            long rightOperations =
                    (prefix[n] - prefix[left])
                    - (long) q * (n - left);

            res.add(leftOperations + rightOperations);
        }

        return res;
    }
}