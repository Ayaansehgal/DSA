class Solution {
    public int reverseBits(int n) {
        String temp = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String result = new StringBuilder(temp).reverse().toString();
        return (int) Long.parseLong(result, 2);
    }
}
