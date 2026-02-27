class Solution {
    boolean[] vis;
    int[] ti;

    static class Pair {
        int time, node;
        public Pair(int time, int node) {
            this.time = time;
            this.node = node;
        }
    }
    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

    private void bfs(int st, int t, List<List<int[]>> adj) {
        q.add(new Pair(t, st));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            vis[p.node] = true;
            ti[p.node] = Math.min(p.time, ti[p.node]);

            for(int[] ver:adj.get(p.node)) {
                int node = ver[0];
                int time = ver[1];

                if(!vis[node])
                    q.add(new Pair(time + p.time, node));
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        vis = new boolean[n + 1];
        ti = new int[n + 1];
        int maxTime = 0;

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] time:times) {
            adj.get(time[0]).add(new int[]{ time[1], time[2] });
        }

        Arrays.fill(ti, Integer.MAX_VALUE);

        bfs(k, 0, adj);

        for(int i=1;i<=n;i++) {
            if(ti[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(ti[i], maxTime);
        }

        return maxTime;
    }
}
