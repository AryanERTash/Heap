//check if array is heap or not

class Solution {
	public boolean isHeap(int[] nums) {
		int n = nums.length;

		for (int i = 0; i <= (n-2)/2; i++) {

			int child1 = 2 * i + 1;
			int child2 = child1 + 1;

			if ((child1 < n && nums[child1] < nums[i])
					|| (child2 < n && nums[child2] < nums[i]))
				return false;

		}

		return true;

	}
	public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {10, 20, 30, 40, 50}; // min-heap
        int[] arr2 = {10, 9, 8, 7, 6};     // not a min-heap
        int[] arr3 = {5};                 // single element
        int[] arr4 = {};                  // empty array
        int[] arr5 = {10, 15, 30, 40, 50, 100, 40}; // min-heap
        int[] arr6 = {10, 15, 5};         // not a min-heap

        System.out.println(sol.isHeap(arr1)); // true
        System.out.println(sol.isHeap(arr2)); // false
        System.out.println(sol.isHeap(arr3)); // true
        System.out.println(sol.isHeap(arr4)); // true
        System.out.println(sol.isHeap(arr5)); // true
        System.out.println(sol.isHeap(arr6)); // false
    }
}