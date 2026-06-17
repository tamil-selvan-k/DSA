class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> cnt = new HashMap<>();

        for(int num:nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> curr:cnt.entrySet()) {
            pq.add(new int[]{curr.getValue(), curr.getKey()});
        }

        int[] top = new int[k];
        for(int i=0;i<k;i++) top[i] = pq.poll()[1];

        return top;
    }
}
