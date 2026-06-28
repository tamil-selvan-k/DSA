class KthLargest {
    PriorityQueue<Integer> heap;
    PriorityQueue<Integer> temp;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>((a, b) -> b-a);
        for(int num:nums) heap.offer(num);
        temp = new PriorityQueue<>();
        this.k = k;
    }
    
    public int add(int val) {
        heap.offer(val);
        int i = 0;
        int res = 0;
        while(i++ < k) {
            temp.offer((res = heap.poll()));
        }

        while(!temp.isEmpty()) {
            heap.offer(temp.poll());
        }

        return res;
    }
}
