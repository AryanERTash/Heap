import java.util.*;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/*
 * Leetcode : https://leetcode.com/problems/merge-k-sorted-lists/
 */

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

		for (ListNode head : lists)
			if(head!=null) pq.offer(head);

		ListNode dummy = new ListNode();
		ListNode current = dummy;

		while (!pq.isEmpty()) {
			ListNode smallestNode = pq.poll();
			current.next = smallestNode;
			current = smallestNode;

			if (smallestNode.next != null)
				pq.offer(smallestNode.next);

		}

		return dummy.next;
	}

}