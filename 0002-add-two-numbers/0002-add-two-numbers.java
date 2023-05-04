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
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		while (l1 != null || l2 != null) {

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum %= 10;
			System.err.println(sum);
			
			current.next = new ListNode(sum);
			current = current.next;
			sum = carry;
		}
		if(carry > 0) {
			current.next = new ListNode(carry);
		}


		return head.next;

	}
}