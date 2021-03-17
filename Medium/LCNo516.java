package leetcodeMedium;

public class LCNo516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbd";
		System.out.println(LongestPalindrome(s));
	}
	
	public static int LongestPalindrome(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		if(n==0) {
			return 0;
		}
		
		int[][] f = new int[n][n];
		//length = 1
		for(int i=0;i<n;i++) {
			f[i][i] = 1;
		}
		//length = 2
		for(int i=0;i<n-1;i++) {
			f[i][i+1] = (ch[i]==ch[i+1]) ? 2 : 1;
		}
		
		//length >2
		for(int len = 3;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				int j = i+len-1;
				f[i][j] = Math.max(f[i+1][j], f[i][j-1]);
				if(ch[i]==ch[j]) {
					f[i][j] = Math.max(f[i][j], f[i+1][j-1]+2);
				}
			}
		}
		return f[0][n-1];
	}

}
