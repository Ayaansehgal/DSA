import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        res.add("");
        for (char d : digits.toCharArray()) {
            List<String> next = new ArrayList<>();
            String letters = map[d - '0'];
            for (String s : res)
                for (char c : letters.toCharArray())
                    next.add(s + c);
            res = next;
        }
        return res;
    }
}
