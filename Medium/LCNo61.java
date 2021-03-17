package leetcodeMedium;


//ListNode is de
public class LCNo61 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=null;
		
		//System.out.println(node1.val);
		node1 = RotateList(node1, 3);
		showList(node1);
		
	}
	
	public static ListNode RotateList(ListNode head, int k) {
		if(head==null) {
			return null;
		}
		
		ListNode tail = head;
		
		int len = 1;
		while(tail.next!=null) {
			len++;
			tail = tail.next;
		}
		tail.next=head;
		
		int step = len - k%len;
		while(step!=0) {
			tail = tail.next;
			step--;
		}
		
		ListNode newhead = tail.next;
		tail.next=null;
		return newhead;
		
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
