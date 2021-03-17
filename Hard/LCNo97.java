package leetcodeHard;

public class LCNo97 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "a";
		String s2 = "";
		String s3 = "a";
		System.out.println(InterleavingString(s1, s2, s3));

	}
	
	public static boolean InterleavingString(String s1, String s2, String s3) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] ch3 = s3.toCharArray();
		
		int n = ch1.length;
		int m = ch2.length;
		if(ch3.length!= (n+m)) {
			return false;
		}
		
		boolean[][] f = new boolean[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				//if both are empty string
				if(i==0 && j==0) {
					f[i][j] = true;
					continue;
				}
				f[i][j] = false;
				//case 1, the last one letter of s3 is from s1
				if(i>0 && ch3[i+j-1] == ch1[i-1]) {
					f[i][j] |= f[i-1][j];
				}
				
				//case 2, the last one letter of s3 is from s2
				if(j>0 && ch3[i+j-1] == ch2[j-1]) {
					f[i][j] |= f[i][j-1];
				}
			}
		}
		return f[n][m];
	}

}
