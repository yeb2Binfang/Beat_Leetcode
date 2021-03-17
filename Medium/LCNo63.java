package leetcodeMedium;

public class LCNo63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]  obstacleGrid = {{1,0}};
		System.out.println(UniquepathIIWithObstacle(obstacleGrid));
		System.out.println(uniquePathII(obstacleGrid));
		
	}
	
	public static int UniquepathIIWithObstacle(int[][] ObstacleGrid) {
		
		int m = ObstacleGrid.length;//rows
		int n = ObstacleGrid[0].length;//cols
		//System.out.println(m);
		int[][] f = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(ObstacleGrid[i][j]==1) {
					f[i][j]=0;
				}else {
					if(i==0 && j==0) {
						f[i][j]=1;
					}else {
						
						if(i==0) {
							f[i][j] = f[i][j-1];
						}else if(j==0) {
							f[i][j] = f[i-1][j];
						}else {
							f[i][j] = f[i][j-1] + f[i-1][j];
						}
					}
						
				}
					
			}
		}
		
		return f[m-1][n-1];
	
	}
	
	
	public static int uniquePathII(int[][] obstacleGrid) {
		int m = obstacleGrid[0].length;//cols
		int n = obstacleGrid.length;//rows
		
		int[]  f = new int[m];
		f[0] = obstacleGrid[0][0] == 0? 1 : 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(obstacleGrid[i][j]==1) {
					f[j]=0;
					continue;
				}
				
				if(j-1>=0 && obstacleGrid[i][j-1]==0) {
					f[j] +=f[j-1];
				}
			}
		}
		return f[m-1];
	}

}
