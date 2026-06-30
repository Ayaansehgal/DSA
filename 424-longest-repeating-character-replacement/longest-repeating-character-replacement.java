class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}