class cc {
    int count;
    char c;

    public cc(int count, char c) {
        this.count = count;
        this.c = c;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<cc> heap = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) {
            heap.add(new cc(a, 'a'));
        }
        if (b > 0) {
            heap.add(new cc(b, 'b'));
        }
        if (c > 0) {
            heap.add(new cc(c, 'c'));
        }

        StringBuilder res = new StringBuilder();

        while (!heap.isEmpty()) {

            cc maxe = heap.poll();
            int count = maxe.count;
            char ch = maxe.c;

            int n = res.length();

            if (n >= 2 && res.charAt(n - 1) == ch && res.charAt(n - 2) == ch) {

                if (heap.isEmpty()) {
                    break;
                }

                cc sec = heap.poll();
                int sc = sec.count;
                char sch = sec.c;

                res.append(sch);
                sc--;

                if (sc > 0) {
                    heap.add(new cc(sc, sch));
                }

                heap.add(maxe);
            } else {

                res.append(ch);
                count--;

                if (count > 0) {
                    heap.add(new cc(count, ch));
                }
            }
        }

        return res.toString();
    }
}