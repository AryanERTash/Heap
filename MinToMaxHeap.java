class Solution {
	private static void swap(long[] arr, int i, int j) {
		long temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void heapifyDown(long[] arr, int i, int boundaryIndex) {

		int parent = i; // i is parennt
		while (true) {
			int leftChild = 2 * parent + 1; // since 0 based indexing
			int rightChild = leftChild + 1;

			int max = leftChild;

			if (leftChild > boundaryIndex)
				break;

			if (rightChild <= boundaryIndex && arr[rightChild] > arr[leftChild]) {
				max = rightChild;
			}

			if (arr[parent] < arr[max]) {
				swap(arr, parent, max);
				parent = max;
			} else
				break;
		}

	}

	public static void minHeapToMaxHeap(long[] arr) {
		int n = arr.length;

		int nonLeaf = (n / 2) - 1;

		for (int i = nonLeaf; i >= 0; i--) {

			heapifyDown(arr, i, n-1);

		}

	}
}
