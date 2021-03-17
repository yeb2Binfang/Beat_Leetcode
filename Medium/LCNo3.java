package leetcodeMedium;

import java.util.HashMap;

public class LCNo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int len = 0;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				//example:"tmmzuxt", that is why need to max 
				left = Math.max(left, map.get(ch)+1);
			}
			//needs to keep updating the postition
			map.put(ch, i);
			len = Math.max(len, i-left+1);
			
		}
		return len;

    }

}
