package leetcodeMedium;

import java.util.ArrayList;

public class LCNo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(9);
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(9);
		
		
		
		node1.next = null;
		
		node2.next = node3;
		node3.next = node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		
		//System.out.println(AddTwoNumbers(node1,node4));
		
		//ListNode Node = AddTwoNumbers(node1, node2);
		ListNode node = AddTwoNumbersMethod2(node1, node2);
		LCNo86.showList(node);

	}
	
	public static ListNode AddTwoNumbers(ListNode L1, ListNode L2) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		ListNode head1 = reverseList(L1);
		ListNode head2 = reverseList(L2);
		
		list1 = getNumber(head1);
		list2 = getNumber(head2);
		
		int l1_val = listToInt(list1);
		int l2_val = listToInt(list2);
		System.out.println(l1_val);
		System.out.println(l2_val);
		
		int sum = l1_val + l2_val;
		
		ListNode res = intToLinkedlist(sum);
		return reverseList(res);
		
		
		
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		
		return pre;
	}
	
	public static ArrayList<Integer> getNumber(ListNode head){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		ListNode temp = head;
		while(temp!=null) {
			list.add(temp.val);
			temp = temp.next;
		}
		
		return list;
	}
	
	public static int listToInt(ArrayList<Integer> list) {
		int num = 0;
		for(int value : list) {
			num = num*10 + value;
		}
		
		return num;
	}
	
	public static ListNode intToLinkedlist(int num) {
		String s1 = Integer.toString(num);
		char[] ch = s1.toCharArray();
		ListNode dummyHead = new ListNode(-1);
		ListNode temp = dummyHead;
		
		for(int i=0;i<ch.length;i++) {			
			ListNode node = new ListNode(Character.getNumericValue(ch[i]));
			temp.next = node;
			temp = temp.next;
		}
		temp.next = null;
		
		return dummyHead.next;
	}
	
	public static ListNode AddTwoNumbersMethod2(ListNode L1, ListNode L2) {
		ListNode head = null;
		ListNode tail = null;
		
		int carry = 0;
		
		while(L1!=null || L2!=null) {
			int num1 = L1==null ? 0 : L1.val;
			int num2 = L2==null ? 0 : L2.val;
			
			int sum = num1 + num2 + carry;
			
			if(head == null) {
				head = tail = new ListNode(sum%10);
			}else {
				tail.next = new ListNode(sum%10);
				tail = tail.next;
			}
			
			carry = sum/10;
			
			if(L1!=null) {
				L1 = L1.next;
			}
			if(L2 != null) {
				L2 = L2.next;
			}
		}
		if(carry>0) {
			tail.next = new ListNode(carry);
			tail = tail.next;
		}
		tail.next = null;
		return head;
	}

}
