public class Solution {
    public static long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();
        int n = basket1.length;
        int minVal = Integer.MAX_VALUE;
        for (int x : basket1) {
            freq1.put(x, freq1.getOrDefault(x, 0) + 1);
            total.put(x, total.getOrDefault(x, 0) + 1);
            minVal = Math.min(minVal, x);
        }
        for (int x : basket2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
            total.put(x, total.getOrDefault(x, 0) + 1);
            minVal = Math.min(minVal, x);
        }
        for (int count : total.values()) {
            if (count % 2 != 0) {
                return -1;
            }
        }
        List<Integer> extra1 = new ArrayList<>();
        List<Integer> extra2 = new ArrayList<>();
        for (int val : total.keySet()) {
            int diff = freq1.getOrDefault(val, 0) - freq2.getOrDefault(val, 0);
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) extra1.add(val);
            } else if (diff < 0) {
                for (int i = 0; i < -diff / 2; i++) extra2.add(val);
            }
        }
        Collections.sort(extra1);
        extra2.sort(Collections.reverseOrder());
        long res = 0;
        for (int i = 0; i < extra1.size(); i++) {
            int a = extra1.get(i);
            int b = extra2.get(i);
            res += Math.min(Math.min(a, b), 2 * minVal);
        }
        return res;
    }
}
