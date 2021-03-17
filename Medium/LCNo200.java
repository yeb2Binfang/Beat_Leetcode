package leetcodeMedium;

public class LCNo200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int numIslands(char[][] grid) {
		if(grid.length==0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		int count=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(grid[i][j]=='0') {
					continue;
				}
				dfs(grid,i,j);
				count++;
			}
		}
		
		return count;
    }
	
	public static void dfs(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;
		if(i<0||j<0|| i>rows||j>cols) {
			return;
		}
		if(grid[i][j]==0) {
			return;
		}
		grid[i][j]='0';
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		
	}

}
