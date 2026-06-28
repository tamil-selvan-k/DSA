class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num:stones) pq.add(num);
        while(pq.size() >= 2) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int wt = (n1 == n2)?0:(n1 > n2)?n1-n2:0;
            pq.add(wt);
        }

        return (pq.isEmpty())?0:pq.poll();
    }
}
