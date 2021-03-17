package leetcodeMedium;

public class LCNo188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {3,2,6,5,0,3};
		int k = 2;
		System.out.println(BestTimeBuyAndSellStockIV(prices, k));

	}
	
	public static int BestTimeBuyAndSellStockIV(int[] prices, int k) {
		if(k==0 || prices.length==0) {
			return 0;
		}
		int n = prices.length;
		int[][] f = new int[n][2*k+1];
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<2*k+1;j++) {
				if(i==0 && j%2!=0) {
					f[i][j] = -prices[i];
				}else if(i>=1) {
					
					f[i][0] = f[i-1][0];
					if(j>=1 && j%2!=0) {
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-1]-prices[i]);
					}else if(j>=1 && j%2 == 0) {
						f[i][j] = Math.max(f[i-1][j], f[i-1][j-1]+prices[i]);
					}
					
				}
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<2*k+1;i+=2) {
			max = Math.max(f[n-1][i], max);
		}
		return max;
	}

}
