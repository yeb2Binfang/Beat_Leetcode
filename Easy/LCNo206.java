package leetcodeEasy;

import leetcodeMedium.LCNo86;
import leetcodeMedium.ListNode;

public class LCNo206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		//ListNode node = ReverseLinkedList(node1);
		ListNode node = reverseList(node1);
		LCNo86.showList(node);

	}
	
	public static ListNode ReverseLinkedList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		
		return pre;
		
	}
	
	public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



}
