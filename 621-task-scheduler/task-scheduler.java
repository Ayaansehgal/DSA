class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxfreq = 0;
        for (char i : tasks) {
            int index = i - 'A';
            freq[index]++;
            maxfreq = Math.max(maxfreq, freq[index]);
        }
        int taskmax = 0;
        for (int i : freq) {
            if (i == maxfreq) {
                taskmax++;
            }
        }
        int res = (maxfreq - 1) * (n + 1) + taskmax;
        return Math.max(tasks.length, res);
    }
}