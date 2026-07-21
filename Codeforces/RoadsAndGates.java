import java.util.*;

public class RoadsAndGates {
    static class Pair {
        int city; long time;
        public Pair (long time, int city) {
            this.time = time;
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        int N = get.nextInt();
        int M = get.nextInt();
        int Y = get.nextInt();
        Map<Integer, List<Pair>> g = new HashMap<>();
        for(int city = 1; city <= N + 2; city++) g.put(city, new ArrayList<>());
        for(int road = 0; road < M; road++) {
            int u = get.nextInt();
            int v = get.nextInt();
            long t = get.nextLong();
            g.get(u).add(new Pair(t, v));
            g.get(v).add(new Pair(t, u));
        }

        g.get(N + 1).add(new Pair(Y, N + 2));
        for(int curr=1;curr<=N;curr++) {
            long wgt = get.nextLong();
            g.get(curr).add(new Pair(wgt, N+1));
            g.get(N + 2).add(new Pair(wgt, curr));
        }

        long[] time = new long[N + 3];
        Arrays.fill(time, Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0L, 1));
        time[1] = 0;

        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            int currCity = node.city;
            long currTime = node.time;
            if(currTime > time[currCity]) continue;
            for(Pair lcp:g.get(currCity)) {
                long newTime = currTime + lcp.time;
                int newCity = lcp.city;
                if(newTime < time[newCity]) {
                    pq.add(new Pair(newTime, newCity));
                    time[newCity] = newTime;
                }
            }
        }

        for(int c=2; c <= N; c++) {
            System.out.print(time[c] + " ");
        }
    }
}