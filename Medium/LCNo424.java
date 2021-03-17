package leetcodeMedium;

public class LCNo424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BAAA";
		int k = 0;
		System.out.println(characterReplacement(s, k));

	}
	
	public static int characterReplacement(String s, int k) {
		
		int[] fre = new int[26];
		int left = 0;
		int right = 0;
		int maxCount = 0;
		while(right<s.length()) {
			int ascii_index = s.charAt(right)-'A';
			fre[ascii_index]++;
			maxCount = Math.max(maxCount, fre[ascii_index]);
			if(right-left+1 > maxCount+k) {
				fre[s.charAt(left)-'A']--;
				left++;
			}
			right++;
		}
		return right - left;
    }

}
