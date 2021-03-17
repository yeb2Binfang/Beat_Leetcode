package leetcodeMedium;

public class LCNo361 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'0','E','0','0'},{'E','E','W','E'},{'0','E','0','0'}};
		char[][] grid1 = {};
		System.out.println(BombEnemyBruteForce(grid));
		System.out.println(BombEnemyDP(grid));
		System.out.println(Maxkill(grid));

	}
	
	public static int BombEnemyBruteForce(char[][] matrix) {
		int die = 0;
		int temp = 0;
		int positioni;
		int positionj;
		int m = matrix.length;
		if(m==0) {
			return 0;
		}
		int n = matrix[0].length;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]== '0') {
					//up
					positioni = i;
					while(positioni>=0) {
						if(matrix[positioni][j] =='W') {
							break;
						}else if(matrix[positioni][j]=='E') {
							die++;
						}
						positioni--;
					}
					//down
					positioni = i;
					while(positioni<m) {
						if(matrix[positioni][j] =='W') {
							break;
						}else if(matrix[positioni][j]=='E') {
							die++;
						}
						positioni++;
					}
					//left
					positionj = j;
					while(positionj>=0) {
						if(matrix[i][positionj] =='W') {
							break;
						}else if(matrix[i][positionj]=='E') {
							die++;
						}
						positionj--;
					}
					positionj = j;
					while(positionj<n) {
						if(matrix[i][positionj] =='W') {
							break;
						}else if(matrix[i][positionj]=='E') {
							die++;
						}
						positionj++;
					}
				}
				temp = Math.max(die, temp);
				die = 0;
			}
		}
		
		return temp;
	}
	
	public static int BombEnemyDP(char[][] grid) {
		int m = grid.length;//rows
		if(m==0) {
			return 0;
		}
		int n = grid[0].length;//cols
		
		
		
		int[][] f = new int[m][n];//store up,down,right,left can kill how many enemies
		int[][] res = new int[m][n];//store the result
		//up
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(grid[i][j] == 'E') {
						f[i][j] =1;
					}
					
					if(i-1>=0) {
						f[i][j] += f[i-1][j];
					}
				}
				res[i][j] += f[i][j];
			}
		}
		
		
		//down
		for(int i=m-1;i>=0;i--) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == 'W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(grid[i][j] == 'E') {
						f[i][j] =1;
					}
					if(i+1<m) {
						f[i][j] += f[i+1][j];
					}
				}
				res[i][j] += f[i][j];
			}
		}
		
		
		
		
		//left
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == 'W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(grid[i][j] == 'E') {
						f[i][j] =1;
					}
					if(j-1>=0) {
						f[i][j] += f[i][j-1];
					}
				}
				res[i][j] += f[i][j];
			}
		}
		
		
		//right
		for(int i=0;i<m;i++) {
			for(int j=n-1;j>=0;j--) {
				if(grid[i][j] == 'W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(grid[i][j] == 'E') {
						f[i][j] =1;
					}
					if(j+1<n) {
						f[i][j] += f[i][j+1];
					}
				}
				res[i][j] += f[i][j];
			}
		}
		
		
		
		//res
		int temp=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='0') {
					temp = Math.max(temp, res[i][j]);
				}
			}
		}
		return temp;
		
	}
	
	public static int Maxkill(char[][] A) {
		if(A==null || A.length==0 || A[0].length==0){
			return 0;
		}
		int m = A.length;
		int n = A[0].length;
		int[][] f = new int[m][n];
		int[][] res = new int[m][n];
		
		int i, j;
		for(i=0;i<m;i++) {
			for(j=0;j<n;j++) {
				res[i][j] = 0;
			}
		}
		
		//up
		for(i=0;i<m;i++) {
			for(j=0;j<n;j++) {
				if(A[i][j]=='W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(A[i][j] == 'E') {
						f[i][j] = 1;
					}
					
					if(i-1>=0) {
						f[i][j] +=f[i-1][j];
					}
				}
				res[i][j] += f[i][j];
				
			}
		}
		
		//down
		for(i=m-1;i>=0;i--) {
			for(j=0;j<n;j++) {
				if(A[i][j]=='W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(A[i][j] == 'E') {
						f[i][j] = 1;
					}

					if(i+1<m) {
						f[i][j] +=f[i+1][j];
					}
				}
				res[i][j] += f[i][j];

			}
		}
		
		//left
		for(i=0;i<m;i++) {
			for(j=0;j<n;j++) {
				if(A[i][j]=='W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(A[i][j] == 'E') {
						f[i][j] = 1;
					}

					if(j-1>=0) {
						f[i][j] +=f[i][j-1];
					}
				}
				res[i][j] += f[i][j];

			}
		}
		
		//right
		for(i=0;i<m;i++) {
			for(j=n-1;j>=0;j--) {
				if(A[i][j]=='W') {
					f[i][j] = 0;
				}else {
					f[i][j] = 0;
					if(A[i][j] == 'E') {
						f[i][j] = 1;
					}

					if(j+1<n) {
						f[i][j] +=f[i][j+1];
					}
				}
				res[i][j] += f[i][j];

			}
		}
		
		int result = 0;
		for(i=0;i<m;i++) {
			for(j=0;j<n;j++) {
				if(A[i][j] =='0') {
					if(res[i][j]>result) {
						result = res[i][j];
					}
				}
			}
		}
		
		return result;
				
		

		
	}

}
