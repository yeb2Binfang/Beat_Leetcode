package leetcodeEasy;

import java.util.Stack;
/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 *  # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 * 
 * */
public class LCNo844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a##c";
		String t = "#a#c";
		System.out.println(backspace(s, t));

	}
	
	public static boolean backspace(String s, String t) {
		if(s==null && t==null) {
			return true;
		}
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for(int i=0;i<a.length;i++) {
			if(a[i] !='#') {
				stack1.push(a[i]);
			}else {
				if(stack1.empty())
				{
					continue;
				}else {
					stack1.pop();
				}
			}
		}
		
		for(int i=0;i<b.length;i++) {
			if(b[i] !='#') {
				stack2.push(b[i]);
			}else {
				if(stack2.empty())
				{
					continue;
				}else {
					stack2.pop();
				}
			}
		}
		
		return stack1.equals(stack2);
	}

}
