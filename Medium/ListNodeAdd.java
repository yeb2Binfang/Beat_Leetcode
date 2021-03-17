package leetcodeMedium;

import java.util.List;

public class ListNodeAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,9,9,9};
		LCNo86.showList(addNodes(arr));

	}
	
	//use to add list node
	public static ListNode addNodes(int[] arr) {
		ListNode dummyhead = new ListNode(-1);
		ListNode temp = dummyhead;
		for(int val : arr) {
			temp.next = new ListNode(val);
			temp = temp.next;
		}
		temp.next = null;
		return dummyhead.next;
	}
	
	//to show the list
	public static void showList(ListNode head) {
		if(head==null) {
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
