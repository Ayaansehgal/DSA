class MyCalendarThree {
    Map<Integer, Integer> map;

    public MyCalendarThree() {  
        map=new TreeMap<Integer,Integer>();
    }
    
    public int book(int s, int e) {
        int b=0,
        max=0;
        map.put(s,map.getOrDefault(s,0)+1);
        map.put(e,map.getOrDefault(e,0)-1);
        for(Map.Entry<Integer,Integer> en:map.entrySet()){
            b+=en.getValue();
            max=Math.max(max,b);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */