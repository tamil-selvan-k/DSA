class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        int min = minHeap.size();
        int max = maxHeap.size();
        if(min == 0 && max == 0) {
            maxHeap.add(num);
        } else if(maxHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

        if(minHeap.size() + 2 == maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() == maxHeap.size() + 2) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if(maxHeap.size() + 1 == minHeap.size()) {
            return minHeap.peek();
        } 
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
