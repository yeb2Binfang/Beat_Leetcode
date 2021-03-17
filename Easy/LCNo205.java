package leetcodeEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LCNo205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdef";
		String s2 = "fedcba";
		System.out.println(isIsomorphicHashmap(s1, s2));
		
		String s3 = "aaaaaaaa";
		for(int i=0;i<s3.length();i++) {
			System.out.println(s3.indexOf('a'));
		}
		

	}
	
	public static boolean isIsomorphicHashmap(String s1, String s2) {
        Map<Character,Integer> hashmap1 = new HashMap<Character, Integer>();
		Map<Character,Integer> hashmap2 = new HashMap<Character, Integer>();
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		for(int i=0;i<ch1.length;i++) {
			if(hashmap1.containsKey(ch1[i])) {
				hashmap1.replace(ch1[i], hashmap1.get(ch1[i]));
			}else {
				hashmap1.put(ch1[i], i);
			}
		}
		for(int i=0;i<ch2.length;i++) {
			if(hashmap2.containsKey(ch2[i])) {
				hashmap2.replace(ch2[i], hashmap2.get(ch2[i]));
			}else {
				hashmap2.put(ch2[i], i);
			}
		}
		if(new ArrayList<>(hashmap1.values()).equals(new ArrayList<>(hashmap2.values()))) {
			return true;
		}
		
		return false;
    }
	
	public static boolean isIsomorphic(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		if(s1.length()!=s2.length()) {
			return false;
		}
		for(int i=0;i<ch1.length;i++) {
			if(s1.indexOf(ch1[i])!=s2.indexOf(ch2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isIsomorphicHash(String s1, String s2) {
		Map<Character,Character> hashmap = new HashMap<Character, Character>();
		for(int i=0;i<s1.length();i++) {
			if(hashmap.containsKey(s1.charAt(i))) {
				if(hashmap.get(s1.charAt(i))!=s2.charAt(i)) {
					return false;
				}
			}else {
				hashmap.put(s1.charAt(i), s2.charAt(i));
			}
		}
		
		return true;
	}
	


}
