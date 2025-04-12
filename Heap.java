import java.util.*;

class MinHeap {
	private ArrayList<Integer> heap;

	MinHeap() {
		this.heap = new ArrayList<>();
		add(0);
	}

	public void insert(int val) {
		add(val);
		set(0, size() + 1);

		int child = size();
		int parent = child / 2;

		while (parent != 0 && get(child) < get(parent)) {
			swap(child, parent);
			child = parent;
			parent /= 2;
		}
	}

	public void delete(int index) {
		// if (index > size() || index <= 0)
		// throw new IndexOutOfBoundsException("Index out of bounds");

		int size = size();
		set(index, get(size));
		set(0, --size);

		int parent = index;

		while (true) {
			int leftChild = 2 * parent;
			int rightChild = leftChild + 1;

			if (leftChild > size)
				break;

			int min = leftChild;

			if (rightChild <= size && get(rightChild) < get(leftChild)) {
				min = rightChild;
			}

			if (get(min) >= get(parent))
				break;

			swap(min, parent);
			parent = min;
		}
	}

	public int size() {
		return get(0);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int get(int i) {
		return heap.get(i);
	}

	private void add(int val) {
		heap.add(val);
	}

	private void set(int i, int val) {
		heap.set(i, val);
	}

	private void swap(int i, int j) {
		int temp = get(i);
		set(i, get(j));
		set(j, temp);
	}

}