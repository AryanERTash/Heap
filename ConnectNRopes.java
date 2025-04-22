import java.util.*;

class Solution {
	public static int minCost(int[] arr) {
		PriorityQueue<Integer> costQueue = new PriorityQueue<>();

		for (int num : arr)
			costQueue.offer(num);

		int cost = 0;
		while (costQueue.size() > 1) {

			int c1 = costQueue.poll();
			int c2 = costQueue.poll();
			int cst = c1 + c2;

			cost += cst;

			costQueue.offer(cst);

		}


		return cost;

	}
}