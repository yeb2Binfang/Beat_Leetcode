package leetcodeMedium;

import java.util.LinkedList;


public class LCNo86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		
		
		
//		for(int i=0;i<6;i++) {
//			System.out.println(node1.val);
//			node1= node1.next;
//		}
		
		ListNode res = PartitionLinkedList(node1, 3);
		showList(res);
		
		
		

	}
	
	public static ListNode PartitionLinkedList(ListNode head, int x) {
		//will go through the list
		ListNode temp = head;
		
		//as the big list head node
		ListNode bigList = new ListNode(-1);
		
		//as the small list head node
		ListNode smallList = new ListNode(-1);
		
		//store the bigList and smallList head
		ListNode bigTemp = bigList;
		ListNode smallTemp = smallList;
		
		while(temp!=null) {
			if(temp.val < x) {
				smallTemp.next = temp;
				smallTemp = smallTemp.next;
			}else {
				bigTemp.next = temp;
				bigTemp = bigTemp.next;
			}
			temp = temp.next;
		}
		
		//very important
		bigTemp.next = null;
		smallTemp.next = bigList.next;
		return smallList.next;
		
		
	}
	
	public static void showList(ListNode head) {
		if(head.next==null) {
			System.out.println("the list is empty");
			return;
		}
		
		ListNode temp = head;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

}
