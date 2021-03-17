package leetcodeEasy;


/*
 * https://blog.csdn.net/jianyuerensheng/article/details/51200274去搞懂来
 * 
 * */
class Listnode{
	int val;
	Listnode next;
	public Listnode() {
		
	}
	public Listnode(int val) {
		this.val=val;
	}
	public Listnode(int val, Listnode next) {
		super();
		this.val = val;
		this.next = next;
	}

	
}

public class LCNo21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Listnode MergeTwoSortedList(Listnode l1, Listnode l2) {
		Listnode head = new Listnode(-1);
		
		while(l1.next!=null && l2.next!=null) {
			if(l2.val>l1.val) {
				head.next=l1;
				head = head.next;
				l1 = l1.next;
				
			}else {
				head.next=l2;
				head = head.next;
				l2=l2.next;
			}
		}
		
		if(l1 == null) {
			head.next = l2;
		}else{
			head.next = l1;
		}
		
		return head.next;
		
	}

}
