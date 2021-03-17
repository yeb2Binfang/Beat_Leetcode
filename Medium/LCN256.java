package leetcodeMedium;

public class LCN256 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(paintHouse(costs));

	}
	
	public static int paintHouse(int[][] costs) {
		if(costs.length==0) {
			return 0;
		}
		int rows = costs.length+1;
		int cols = costs[0].length;
		int[][] f = new int[rows][cols];
		
		for(int i=1;i<rows;i++){
			f[i][0] = Math.min(f[i-1][1] + costs[i-1][0],f[i-1][2] + costs[i-1][0]);
			f[i][1] = Math.min(f[i-1][0] + costs[i-1][1],f[i-1][2] + costs[i-1][1]);
			f[i][2] = Math.min(f[i-1][0] + costs[i-1][2],f[i-1][1] + costs[i-1][2]);
		}
		int temp = Math.min(f[rows-1][0], f[rows-1][1]);
		int min = Math.min(temp, f[rows-1][2]);
		return min;
	}

}
