package leetcodeMedium;

import java.util.HashMap;

public class LCNo159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));

	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
		if(s.length()==0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int len = 0;
		
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			map.put(ch, i);
			
			int leftmost = s.length();
			if(map.size()>2) {
				for(int num : map.values()){
					leftmost = Math.min(leftmost, num);
				}
				map.remove(s.charAt(leftmost));
				start = leftmost + 1;
			}
			
			len = Math.max(len, i-start+1);
		}
		return len;
    }

}
