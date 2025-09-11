class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char res[]=s.toCharArray();
            Arrays.sort(res);
            String temp=new String(res);
            map.putIfAbsent(temp,new ArrayList<>());
            map.get(temp).add(s);
        }
    return new ArrayList<>(map.values());

    }
}