public class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int odd = 0, even = 1;
        int sum = 0, result = 0;
        for (int num : arr) {
            sum = (sum + num) % 2;
            if (sum == 0) {
                result = (result + odd) % mod;
                even++;
            } else {
                result = (result + even) % mod;
                odd++;
            }
        }
        return result;
    }
}
