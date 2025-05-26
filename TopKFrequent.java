/*
 * Leetcode: https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;

class Solution {
	public int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer>[] freqMap = new ArrayList[nums.length + 1];
		int[] result = new int[k];
		int j = 0;

		for (int num : nums) {

			map.put(num, map.getOrDefault(num, 0) + 1);

		}

		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

		for (Map.Entry<Integer, Integer> entry : entrySet) {
			if (freqMap[entry.getValue()] == null)
				freqMap[entry.getValue()] = new ArrayList<>();

			freqMap[entry.getValue()].add(entry.getKey());
		}

		for (int i = freqMap.length - 1; i >= 0 && k > 0; i--) {

			if (freqMap[i] == null)
				continue;

			ArrayList<Integer> elementList = freqMap[i];

			for (int num : elementList) {
				if (k <= 0)
					break;

				k--;
				result[j++] = num;
			}

		}
		return result;

	}
}