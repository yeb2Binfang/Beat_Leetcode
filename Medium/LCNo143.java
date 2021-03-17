package leetcodeMedium;

public class LCNo143 {

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
		
		ListNode node = ReorderList(node1);
		
		LCNo86.showList(node);

	}
	
	public static ListNode ReorderList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode mid = FindMiddle(head);
		ListNode L1 = head;
		ListNode L2 = ReverseList(mid.next);
		mid.next = null;
		
		ListNode res = mergeList(L1, L2);
		
		return res;
	}
	
	public static ListNode FindMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		/*recall: when we did the question, LCNo876, if it has two middle nodes, then it will
		 * return the second node. So, the condition is (fast != null && fast.next!=null).
		 * 
		 * However, here, we need to return the first middle node, because we need in reorder list,
		 * after the first middle node, mid.next = null
		 * that is why here, the condition is (fast.next != null && fast.next.next != null)
		 * 
		 */
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public static ListNode ReverseList(ListNode head) {
		
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
	
	public static ListNode mergeList(ListNode L1, ListNode L2) {
		
		ListNode L1_temp;
		ListNode L2_temp;
		ListNode dummyhead = new ListNode(-1);
		dummyhead.next = L1;
		while(L1 != null && L2 !=null) {
			L1_temp = L1.next;
			L2_temp = L2.next;
			
			L1.next = L2;
			L1 = L1_temp;
			
			L2.next = L1;
			L2 = L2_temp;
		}
		
		return dummyhead.next;
	}


}
