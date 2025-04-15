import java.util.*;

class Solution {
	public boolean isNStraightHand(int[] hand, int groupSize) {

		int n = hand.length;

		if (n % groupSize != 0)
			return false;

		Map<Integer, Integer> map = new HashMap<>();

		for (int m : hand)
			map.put(m, map.getOrDefault(m, 0) + 1);

		PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

		while (!pq.isEmpty()) {
			int first = pq.peek();

			for (int i = 0; i < groupSize; i++) {

				int item = first + i;
				if (!map.containsKey(item) || map.get(item) == 0)
					return false;
				map.put(item, map.get(item) - 1);

				if (map.get(item) == 0 && pq.peek() == item) {
					pq.poll();
				}

			}
		}

		return true;

	}
}