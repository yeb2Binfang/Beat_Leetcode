package leetcodeMedium;

public class LCNo92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		
		ListNode node = ReverseLikedListII(node1, 2, 4);
		LCNo86.showList(node);

	}
	
	public static ListNode ReverseLikedListII(ListNode head, int m, int n) {
		if(head==null || head.next==null) {
			return head;
		}
		
		int step = n-m + 1;
		
		ListNode headTemp = head;
		ListNode pre = null;
		
		while(m>1) {
			pre = headTemp;
			headTemp = headTemp.next;
			m--;
			n--;
		}
		
		System.out.println(n);
		System.out.println(step);
		ListNode con = pre;
		ListNode tail = headTemp;
		
		while(step>0) {
			ListNode next = headTemp.next;
			headTemp.next = pre;
			pre = headTemp;	
			headTemp = next;					
			step--;
			
		}
		
		if(con!=null) {
			//when it starts from 1, then con = null
			con.next = pre;
		}else {
			head = pre;
		}
		
		tail.next = headTemp;
		
		return head;
	}

}
