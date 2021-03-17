package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCNo290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String s1 = "aa bb cc";
//		String[] s2 = s1.split(" ");
//		System.out.println(Arrays.toString(s2));
		
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern2(pattern, s));

	}
	
	public static boolean wordPattern(String pattern, String s) {
		Map<Character, String> hashmap = new HashMap<Character, String>();
		Map<String, Character> hashmap2 = new HashMap<String, Character>();
		
		String[] s1 = s.split(" ");
		char[] c1 = pattern.toCharArray();
		if(s1.length != c1.length) {
			return false;
		}
		
		for(int i=0;i<c1.length;i++) {
			if(hashmap.containsKey(c1[i])) {
				boolean flag = hashmap.get(c1[i]).equals(s1[i]);
				if(!flag) {
					return false;
				}
				
			}else {
				hashmap.put(c1[i], s1[i]);
			}
			
			if(hashmap2.containsKey(s1[i])) {
				if(hashmap2.get(s1[i])!=c1[i]) {
					return false;
				}
				
			}else {
				hashmap2.put(s1[i], c1[i]);
			}
		}
		
		
		return true;
	}

	
	public static boolean wordPattern2(String pattern, String s) {
		Map<String, Character> hashmap = new HashMap<String, Character>();
		Map<Character, String> hashmap2 = new HashMap<Character, String>();
		
		String[] s1 = s.split(" ");
		if(s1.length != pattern.length()) {
			return false;
		}
		
		for(int i=0;i<pattern.length();i++) {
			char c1 = pattern.charAt(i);
			if(hashmap.containsKey(s1[i]) && !hashmap.get(s1[i]).equals(c1)) {
				return false;
			}else {
				hashmap.put(s1[i], c1);
			}
			if(hashmap2.containsKey(c1) && !hashmap2.get(c1).equals(s1[i])) {
				return false;
			}else {
				hashmap2.put(c1, s1[i]);
			}
		}
		
		return true;
	}
}
