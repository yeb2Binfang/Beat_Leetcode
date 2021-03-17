package leetcodeMedium;

import java.util.Arrays;

public class LCNo567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "eidbaooo";
		System.out.println(checkInclusion(s1, s2));

	}
	
	public static boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		if(n>m) {
			return false;
		}
		
		int[] s1Fre = new int[26];
		int[] s2Fre = new int[26];
		
		for(int i=0;i<n;i++) {
			s1Fre[s1.charAt(i)-'a']++;
			s2Fre[s2.charAt(i)-'a']++;
		}
		
		if(Arrays.equals(s1Fre, s2Fre)) {
			return true;
		}
		
		for(int i =n;i<m;i++) {
			s2Fre[s2.charAt(i)-'a']++;
			s2Fre[s2.charAt(i-n)-'a']--;
			if(Arrays.equals(s1Fre, s2Fre)) {
				return true;
			}
		}
		return false;
    }

}
