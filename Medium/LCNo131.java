package leetcodeMedium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LCNo131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> res = new ArrayList<List<String>>();
		String s = "aab";
		System.out.println(partition(s));

	}
	
	public static List<List<String>> partition(String s) {
		
		int len = s.length();
		List<List<String>> res = new ArrayList<List<String>>();
		Deque<String> stack = new ArrayDeque<>();
		if(s.length()==0) {
			return res;
		}
		dfs(s, 0, len,stack, res);
		return res;
		
    }
//	
	
	public static void  dfs(String s, int startIndex, int len, Deque<String> stack, List<List<String>> res) {
		//when move to the last letter
		if(startIndex==len) {
			//deep copy, it is very important
			res.add(new ArrayList<String>(stack));
			return;
		}
		
		for(int i=startIndex;i<len;i++) {
			if(!isParlindrome(s,startIndex, i)) {
				continue;
			}
			stack.addLast(s.substring(startIndex, i + 1));
			dfs(s,i+1,len,stack,res);
			stack.removeLast();
			
		}
	}
	
	public static boolean isParlindrome(String s, int left, int right) {
		
		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
		
	}

}
