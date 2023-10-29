class tuple {
    int start;
    int end;
    int idx;
    public tuple(int a, int b, int c) {
        this.start = a;
        this.end = b;
        this.idx = c;
    }
}

class Solution {
    public static int maxMeetings(int start[], int end[], int n) {
        if (n == 0) return 0;
        
        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.end - y.end);
        for (int i = 0; i < n; i++) {
            pq.add(new tuple(start[i], end[i], i + 1));
        }
        
        int ans = 1;
        int time = pq.peek().end;
        pq.poll();
        
        while (!pq.isEmpty()) {
            int st = pq.peek().start;
            if (st > time) {
                time = pq.peek().end;
                ans++;
            }
            pq.poll();
        }
        
        return ans;
    }
}