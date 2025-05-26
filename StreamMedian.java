/*
 * Find median of input stream
 * Leetcode: https://leetcode.com/problems/find-median-from-data-stream/
 */



import java.util.*;

class MedianFinder {
	PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()),
			rightHeap = new PriorityQueue<>();

	public MedianFinder() {

		leftHeap.clear();
		rightHeap.clear();

	}

	public void addNum(int num) {

		if (leftHeap.isEmpty()) {
			leftHeap.offer(num);
			return;
		}

		int top = leftHeap.peek();

		if (num > top) {
			rightHeap.offer(num);
		} else {
			leftHeap.offer(num);
		}

		if (rightHeap.size() > leftHeap.size()) {
			leftHeap.offer(rightHeap.poll());
		} else if (leftHeap.size() > rightHeap.size() + 1) {
			rightHeap.offer(leftHeap.poll());
		}

	}

	public double findMedian() {

		if (leftHeap.size() > rightHeap.size())
			return leftHeap.peek();

		return (leftHeap.peek() + rightHeap.peek()) / 2.0;

	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */