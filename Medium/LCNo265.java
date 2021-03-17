package leetcodeMedium;

public class LCNo265 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(paintHouseIIBruceForce(costs));
		System.out.println(paintHouseIIDP(costs));
	}
	
	public static int paintHouseIIBruceForce(int[][] costs) {
		if(costs.length==0) {
			return 0;
		}
		
		int m = costs.length+1; //rows
		int n = costs[0].length; //cols
		
		int[][] f = new int[m][n];
		int temp=Integer.MAX_VALUE;
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(k==j) {
						continue;
					}else {
						temp = Math.min(temp, f[i-1][k]);
					}
				}
				f[i][j] = temp + costs[i-1][j];
				temp = Integer.MAX_VALUE;
			}
		}
		temp=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			temp = Math.min(temp, f[m-1][i]);
		}
		return temp;
	}
	
	public static int paintHouseIIDP(int[][] costs) {
		if(costs.length==0) {
			return 0;
		}
		int m = costs.length+1;
		int n = costs[0].length;
		
		int[][] f = new int[m+1][n];
		int min1,min2;
		int j1=0, j2;//store the position of min1, min2
		for(int i=1;i<m;i++) {
			min1 = min2 = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(f[i-1][j]<min1) {
					min2 = min1;
					j2 = j1;
					min1 = f[i-1][j];
					j1 = j;
				}else {
					if(f[i-1][j]<min2) {
						min2 = f[i-1][j];
						j2 = j;
					}
				}
			}
			
			for(int k=0;k<n;k++) {
				if(k!=j1) {
					f[i][k] = min1 + costs[i-1][k];
				}else {
					f[i][k] = min2 + costs[i-1][k];
				}
			}
		}
		
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			temp = Math.min(temp, f[m-1][i]);
		}
		return temp;
	}

}
