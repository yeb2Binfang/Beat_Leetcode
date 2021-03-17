package leetcodeMedium;

public class LCNo1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abcddd";
		String B = "acd";
		System.out.println(LongestCommonSubsequence(A, B));

	}
	
	public static int LongestCommonSubsequence(String A, String B) {
		char[] ch1 = A.toCharArray();
		char[] ch2 = B.toCharArray();
		
		int m = ch1.length;
		int n = ch2.length;
		
		int[][] f = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					f[i][j] = 0;
					continue;
				}
				
				f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
				if(ch1[i-1] == ch2[j-1]) {
					f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
				}
			}
		}
		return f[m][n];
	}

}
