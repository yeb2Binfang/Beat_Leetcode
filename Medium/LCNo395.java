package leetcodeMedium;

import java.util.HashMap;

public class LCNo395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Binfang Ye Ye";
		int k = 2;
		System.out.println(longestSubstring(s, k));

	}
	
	public static int longestSubstring(String s, int k) {
		if(s.length()<k) {
			return 0;
		}
		
		//put frequence to map
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
		}
		
		//recurrsion
		for(char ch : map.keySet()){
			if(map.get(ch)<k) {
				int res = 0;
				for(String t : s.split(String.valueOf(ch))) {
					res = Math.max(res, longestSubstring(t, k));
				}
				return res;
			}
		}
		return s.length();
    }

}
