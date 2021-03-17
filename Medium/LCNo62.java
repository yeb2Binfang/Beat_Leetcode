package leetcodeMedium;

public class LCNo62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCNo62 unique = new LCNo62();
		int m=7;
		int n=3;
		System.out.println(unique.uniquePaths(m, n));

	}
	
	public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];
		int i,j;
		for(i=0;i<m;i++) {//row: top to bottom
			for(j=0;j<n;j++) {//column: left to right
				if(i==0 || j==0) {
					f[i][j]=1;
				}else {
					f[i][j] = f[i-1][j]+f[i][j-1];
				}
			}
		}
		return f[m-1][n-1];
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
