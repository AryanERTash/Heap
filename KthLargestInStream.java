import java.util.*;

class KthLargest {

	private PriorityQueue<Integer> queue;
	private int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<>(k + 1);

		for (int i : nums) {
			add(i);
		}

	}

	public int add(int val) {

		queue.offer(val);

		if (queue.size() > k) {
			queue.poll();
		}

		return queue.peek();

	}

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */