package leetcodeMedium;

import java.util.Stack;

public class LCNo445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,9,9,9,9,9};
		int[] arr1 = {2,9,9,9,9,9};
		
		ListNode node1 = ListNodeAdd.addNodes(arr);
		ListNode node2 = ListNodeAdd.addNodes(arr1);
		
		
		ListNode node = AddTwoNumbersII(node1, node2);
		LCNo86.showList(node);

	}
	
	public static ListNode AddTwoNumbersII(ListNode L1, ListNode L2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack1 = getStackFromList(L1);
		stack2 = getStackFromList(L2);
		int carry = 0;
		ListNode res = null;
		
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			int num1 = stack1.isEmpty() ? 0 : stack1.pop();
			int num2 = stack2.isEmpty() ? 0 : stack2.pop();
			
			int sum = num1 + num2 + carry;
			
			ListNode temp = new ListNode(sum%10);
			carry = sum/10;
			temp.next = res;
			res = temp;
			
		}
		if(carry>0) {
			ListNode temp = new ListNode(carry);
			temp.next = res;
			res = temp;
		}
		return res;
		
	}
	
	public static Stack<Integer> getStackFromList(ListNode head){
		Stack<Integer> stack = new Stack<Integer>();
		
		ListNode temp = head;
		while(temp!=null) {
			stack.push(temp.val);
			temp = temp.next;
		}
		
		return stack;
		
	}
}
