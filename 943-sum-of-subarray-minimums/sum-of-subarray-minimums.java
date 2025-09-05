class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;
        long res = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int cur = (i == n ? 0 : arr[i]); 
            while (!st.isEmpty() && arr[st.peek()] > cur) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                res = (res + (long) arr[mid] * left * right) % MOD;
            }
            st.push(i);
        }
        return (int) res;
    }
}
