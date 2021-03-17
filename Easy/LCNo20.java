package leetcodeEasy;

import java.util.Stack;

public class LCNo20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "(()])";

	}
	
	public static boolean ValidParenthesis(String s) {
		
		Stack<Character> par = new Stack<>();
		
		for (char c : s.toCharArray()) {
			
			if(c=='(' || c=='[' || c== '{') {
				par.push(c);
			}else {
				if(par.isEmpty()) {
					return false;
				}
				
				char topElement = par.pop();
				char matched = '#';
				if(c==')') {
					matched = '(';
				}else if (c==']') {
					matched = '[';
				}else {
					matched = '{';
				}
				
				if(topElement != matched) {
					return false;
				}
				
			}
		}
		
		return par.isEmpty();
	}
	
	
}
