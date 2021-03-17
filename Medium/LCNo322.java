package leetcodeMedium;

public class LCNo322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCNo322 CoinChange= new LCNo322();
		int[] A = {1,2,3};
		int M = 27;
		//System.out.println(CoinChange.coinChange(A, M));
		System.out.println(coinChange2(A, M));
		

	}
	
	public int coinChange(int[] A, int M) {
		//the length of array
		//0....n: [n+1]
		//0...n-1: [n]
		int[] f = new int[M+1];
		
		int n = A.length; // number of types of coins
		
		//init
		f[0] = 0; //important
		//f[1], f[2],...f[27]
		for(int i=1;i<=M;i++) {
			f[i] = Integer.MAX_VALUE;
			
			//last coin A[j]
			//f[i] = min{f[i-A[0]]+1, f[i-A[n-1]]+1}
			for(int j=0;j<n;j++) {
				//the condition is important
				//the boundary
				if(i>=A[j] && f[i-A[j]]!= Integer.MAX_VALUE) {
					//detail, important
					f[i] = Math.min(f[i-A[j]]+1, f[i]);//transfer equation
				}
				
			}
		}
		if(f[M]==Integer.MAX_VALUE) {
			return -1;
		}
		return f[M];
				
	}
	
	
	public static int coinChange2(int[] A, int M) {
		int[] f = new int[M+1];// 0,...M
		int n = A.length; //types of coins
		
		f[0] = 0;
		for(int i=1;i<=M;i++) {
			f[i] = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(A[j] <= i && f[i-A[j]] != Integer.MAX_VALUE) {
					f[i] = Math.min(f[i], f[i-A[j]]+1);
				}
			}
		}
		
		return f[M]==Integer.MAX_VALUE ? -1 : f[M];
  	}

}
