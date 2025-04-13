import java.util.*;
import java.io.*;

/*
 *	Nearly sorted using minheap O(nlogK)
*/
class Solution {

	public static int[] nearlySorted(int[] array, int n, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int p = k + 1;
		for (int i = 0; i < p; i++)
			minHeap.add(array[i]);

		int i = k + 1;
		int ptr = 0;

		while (!minHeap.isEmpty()) {
			array[ptr++] = minHeap.poll();

			if (i < n) {
				minHeap.offer(array[i++]);
			}

		}

		return array;
	}
}