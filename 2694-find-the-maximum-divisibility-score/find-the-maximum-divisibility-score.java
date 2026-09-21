class Solution { 
    public int maxDivScore(int[] nums, int[] d) { 

        int best = d[0]; 
        int maxScore = -1; 
 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for (int i = 0; i < d.length; i++) { 
            map.put(d[i], 0); 
        } 

        for (int i = 0; i < nums.length; i++) { 

            for (int j = 1; j * j <= nums[i]; j++) { 

                if (nums[i] % j == 0) { 

                    if (map.containsKey(j)) {
                        map.put(j, map.get(j) + 1);
                    }

                    int other = nums[i] / j;

                    if (other != j && map.containsKey(other)) {
                        map.put(other, map.get(other) + 1);
                    }
                } 
            } 
        }

        for (int x : d) {
            int score = map.get(x);

            if (score > maxScore || 
                (score == maxScore && x < best)) {
                maxScore = score;
                best = x;
            }
        }

        return best;
    } 
}