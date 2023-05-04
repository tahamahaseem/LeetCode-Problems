/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int sum = 0;
		ListNode head = new ListNode(0);//starting node used as a dummy
		ListNode current = head;//pointer to current node which is the head
		
		while (l1 != null || l2 != null) {//iterates until went through both l1 and l2 nodes

			if (l1 != null) {//iterates until all nodes of l1 are searched
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {//iterates until all nodes of l2 are searched
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;//finds if carry exists
			sum %= 10;//gets sum without the carry (0-9 integers)
		
			current.next = new ListNode(sum);//creates the next node with the sum value
			current = current.next;//moves to the next node
			sum = carry;//resets the sum so that it only starts with the value of the carry
		}
		if(carry > 0) {//accomodates for the LAST carry node
			current.next = new ListNode(carry);
		}


		return head.next;//passes the dummy node

	}
}