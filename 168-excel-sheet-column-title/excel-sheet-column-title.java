public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;  
            int remainder = columnNumber % 26;
            char currentChar = (char) ('A' + remainder);
            res.insert(0, currentChar);
            columnNumber /= 26;
        }

        return res.toString();
    }
}
