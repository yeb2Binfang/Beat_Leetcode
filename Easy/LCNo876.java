package leetcodeEasy;

import leetcodeMedium.ListNode;

public class LCNo876 {


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
		System.out.println(MiddleNode(node1));
		System.out.println(MiddleNodeTwoPointers(node1));
		
		

	}
	
	public static ListNode MiddleNode(ListNode head) {
		int count = 1;
		ListNode temp = head;
		while(temp.next!=null) {
			count++;
			temp = temp.next;
		}
		
		int step = count/2+1;
		ListNode node = head;
		for(int i=1;i<step;i++) {
			node = node.next;
		}
		return node;
	}
	
	public static ListNode MiddleNodeTwoPointers(ListNode head) {
		ListNode pointer1 = head;
		ListNode pointer2= head;
		
		while(pointer2!=null && pointer2.next!=null) {
			pointer2 = pointer2.next.next;
			pointer1 = pointer1.next;
		}
		
		return pointer1;
		
		
	}

}
