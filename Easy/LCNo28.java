package leetcodeEasy;

public class LCNo28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "hello";
		String t = "ll";
		System.out.println(strStrSubstring(p, t));
		System.out.println(strStrBruteForce(p, t));

	}
	
	public static int strStrBruteForce(String p, String t) {
		if(p=="" && t == "") {
			return 0;
		}
		char[] str = p.toCharArray();
		char[] str1 = t.toCharArray();
 		for(int i =0;i< str.length;i++) {
 			int k=i;
			for(int j=0;j<str1.length;j++) {
				
				if(str1[j]==str[k]) {
					k++;
					if(k==str.length) {
						return -1;
					}
					if(j==str1.length-1) {
						return i;
					}
					
				}else {
					break;
				}
			}
			
		}
			
		return -1;
	}
	
	public static int strStrSubstring(String p, String t) {
		int L = t.length();
		int N = p.length();
		
		for (int start =0; start < N-L+1;++start) {
			if(p.substring(start, start+L).equals(t)) {
				return start;
			}
		}
		return -1;
	}
	
	public static void strStrKMP(String p, String t) {
		
	}

}
