class Solution {
    int[] par, size;

    int find(int x) {
        if(x == par[x]) {
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }

    void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if(size[parX] < size[parY]) {
            par[parX] = parY;
            size[parY] += size[parX];
        } else {
            par[parY] = parX;
            size[parX] += size[parY];
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        size = new int[n+1];
        par = new int[n+1];

        for(int i=0;i<=n;i++) {
            size[i] = 1;
            par[i] = i;
        }


        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());

        int[] res = new int[2];

        for(int[] edge:edges) {
            int parX = find(edge[0]);
            int parY = find(edge[1]);

            if(parX == parY) res = new int[]{edge[0], edge[1]};
            union(edge[0], edge[1]);

        }

        return res;
    }
}
