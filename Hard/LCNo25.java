package leetcodeHard;

import leetcodeMedium.ListNode;
import leetcodeMedium.ListNodeAdd;

public class LCNo25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1};
		ListNode head = ListNodeAdd.addNodes(arr);
		//ListNodeAdd.showList(head);
//		ListNode node = reverseList(head, 1,1);
		
		ListNode node = ReverseNodesInKGroup(head, 1);
		//ListNode node = reverseList(head, 1, 2);
		ListNodeAdd.showList(node);
		


	}
	
	public static ListNode reverseList(ListNode head, int m, int n) {
		if(head==null) {
			return null;
		}
		
		ListNode curr = head;
		ListNode pre = null;
		
		//move to the position
		while(m>1) {
			m--;
			n--;
			pre = curr;
			curr = curr.next;		
		}
		
		ListNode con = pre;
		ListNode temp = curr;
		
		while(n>0) {
			n--;
			ListNode next = curr.next;
			curr.next=pre;
			pre = curr;
			curr = next;
			
		}
		
		
		if(con==null) {
			head = pre;
		}else {
			con.next=pre;
		}
		
		temp.next = curr;
		return head;
	}
	
	public static ListNode ReverseNodesInKGroup(ListNode head, int k) {
		int start=1;
		int end = start + k -1;
		int len = getLength(head);
		if(len==1) {
			return head;
		}
		ListNode temp = head;
		if(end<=len) {
			temp = reverseList(head, start, end);
			//ListNodeAdd.showList(temp);
			start = end + 1;
			end = start + k -1;
		}
		
		while(end<=len) {
			temp = reverseList(temp, start, end);
			//ListNodeAdd.showList(temp);
			start = end + 1;
			end = start + k -1;
		}
		
		return temp;
	}
	
	public static int getLength(ListNode head) {
		if(head==null) {
			return 0;
		}
		ListNode temp = head;
		int len = 1;
		while(temp.next!=null) {
			temp = temp.next;
			len++;
		}
		return len;
	}

}
