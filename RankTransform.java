import java.util.*;

class Solution {
	public int[] arrayRankTransform(int[] arr) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < arr.length; i++) {

			pq.offer(new int[] {
					arr[i], i
			});

		}

		int i = 1;

		Map<Integer, Integer> rankMap = new HashMap<>();

		while (!pq.isEmpty()) {
			int[] m = pq.poll();
			int num = m[0];
			int index = m[1];

			if (rankMap.containsKey(num)) {
				arr[index] = rankMap.get(num);
			} else {
				arr[index] = i;
				rankMap.put(num, i);
				i++;
			}

		}
		return arr;
	}
}