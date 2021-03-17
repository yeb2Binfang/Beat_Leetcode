package leetcodeMedium;

public class ListNode {
	
	public int val;
	public ListNode next;

	public ListNode() {
		// TODO Auto-generated constructor stub
	}

	
	public ListNode(int val) {
		super();
		this.val = val;
	}


	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}


	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
	
	

}
