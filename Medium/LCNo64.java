package leetcodeMedium;

public class LCNo64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,3},{4,5,6}};
		System.out.println(MinSumPath(grid));
		System.out.println(MinSumPath2(grid));
	}
	
	public static int MinSumPath(int[][] grid) {
		int m = grid.length;//rows
		int n = grid[0].length;//cols
		if(m==0) {
			return 0;
		}
		
		int[][] f = new int[m+1][n+1];
		//f[0][0] = grid[0][0];
		
		for(int i=0;i<m;i++) {
			
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) {
					f[i][j] = grid[0][0];
				}else {
					if(i==0) {
						f[i][j] =f[i][j-1] + grid[i][j];
					}else if(j==0) {
						f[i][j] = f[i-1][j] + grid[i][j];
					}else {
						f[i][j] = Math.min(f[i-1][j] + grid[i][j], f[i][j-1]+grid[i][j]);
					}
				}
			}
		}
		
		return f[m-1][n-1];
	}
	
	public static int MinSumPath2(int[][] grid) {
		int n = grid[0].length;//cols
		int m = grid.length;//cols
		
		int[] f = new int[n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&&j==0) {
					f[0]=grid[0][0];
				}else {
					if(i==0) {
						f[j] = f[j-1]+grid[i][j];
					}else if(j==0) {
						f[j] = f[j] + grid[i][j];
					}else {
						f[j] = Math.min(f[j-1]+grid[i][j], f[j] + grid[i][j]);
					}
				}
			}
		}
		return f[n-1];
 	}

}
