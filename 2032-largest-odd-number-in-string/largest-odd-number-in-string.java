class Solution {
    public String largestOddNumber(String s) {
         for (int i = s.length() - 1; i >= 0; i--) 
    {

      if (s.charAt(i) % 2 != 0) 
      {

        String s1 = s.substring(0, i + 1);
        return s1;
      }
    }
    return "";
  }
}