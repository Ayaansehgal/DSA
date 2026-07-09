class MyCalendar {
    Map<Integer,Integer> count;
    public MyCalendar() {
        count=new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int s, int e) {
        int booking =0;
         count.put(s,count.getOrDefault(s,0)+1);
         count.put(e,count.getOrDefault(e,0)-1);
         for(Map.Entry<Integer,Integer> en:count.entrySet()){
            booking+=en.getValue();
            if(booking>1){
                count.put(s,count.get(s)-1);
                count.put(e,count.get(e)+1);
                return false;
            }
         }
         return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */