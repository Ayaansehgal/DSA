class MyCalendarTwo {
    Map<Integer,Integer> count;
  

    public MyCalendarTwo() {
        count=new TreeMap<Integer,Integer>();
       
    }
    
    public boolean book(int s, int e) {
        int bookings=0;
        count.put(s,count.getOrDefault(s,0)+1);
         count.put(e,count.getOrDefault(e,0)-1);
         for(Map.Entry<Integer,Integer> en:count.entrySet()){
            bookings=bookings+en.getValue();
            if(bookings>2){
                count.put(s,count.get(s)-1);
                count.put(e,count.get(e)+1);
                return false;
            }
         }
         return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */