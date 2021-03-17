package leetcodeMedium;

public class LCNo148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,6,8,3,5,7};
		int[] arr1 = {2,4,6,8};
		ListNode head = ListNodeAdd.addNodes(arr);
		ListNode head1 = ListNodeAdd.addNodes(arr1);
		//ListNode temp = findMiddle(head);
		//System.out.println(temp);
		//ListNodeAdd.showList(head);
		
		
//		ListNode temp1 = SortList(head);
//		ListNodeAdd.showList(temp1);
		
		ListNode temp2 = SortListMethod2(head);
		ListNodeAdd.showList(temp2);
		
		
//		ListNode res = Merge(head, head1);
//		ListNodeAdd.showList(res);

	}
	public static ListNode SortList(ListNode head) {
		if(head == null || head.next==null) {
			return head;
		}
		
		ListNode mid = findMiddle(head);
		ListNode temp = mid.next;
		mid.next = null;
		
		ListNode left = SortList(head);
		ListNode right = SortList(temp);
		
		ListNode res = Merge(left, right);
		return res;
	}
	
	public static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		if(head==null) {
			return head;
		}
		
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static ListNode Merge(ListNode L1, ListNode L2) {
		ListNode res = new ListNode(-1);
		ListNode temp = res;
		while(L1 != null && L2 != null) {
			if(L1.val<L2.val) {
				temp.next = L1;
				L1 = L1.next;
				temp = temp.next;
			}else {
				temp.next = L2;
				L2 = L2.next;
				temp = temp.next;
			}
		}
		temp.next = L1==null ? L2 : L1;
		
		return res.next;
	}
	
	public static ListNode Split(ListNode head, int step) {
		if(head==null) {
			return null;
		}
		
		ListNode curr = head;
		
		for(int i=1;i<step && curr.next!=null;i++) {
			curr = curr.next;
		}
		
		ListNode temp = curr.next;
		curr.next = null;
		return temp;
	}
	
	public static int getLength(ListNode head) {
		if(head==null) {
			return 0;
		}
		int len = 1;
		ListNode temp = head;
		while(temp.next!=null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	public static ListNode SortListMethod2(ListNode head) {
		if(head==null) {
			return null;
		}
		
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		
		int len = getLength(head);
		
		for(int step = 1;step < len; step*=2) {
			ListNode pre = dummyHead;
			ListNode curr = pre.next;
			
			while(curr!=null) {
				ListNode h1 = curr;
				ListNode h2 = Split(h1, step);
				curr = Split(h2, step);
				ListNode temp = Merge(h1, h2);
				pre.next = temp;
				while(pre.next!=null) {
					pre= pre.next;
				}
			}
		}
		return dummyHead.next;
	}

}
