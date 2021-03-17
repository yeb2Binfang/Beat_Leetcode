package leetcodeHard;

public class LCNo312 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ballon = {1,5};
		System.out.println(BurstBallon(ballon));

	}
	
	public static int BurstBallon(int[] ballon) {
		int n = ballon.length;
		if(n==0) {
			return 0;
		}
		int[] ballon1 = new int[n+2];
		//the first one and the last one cannot be bursted. Set it to value 1.
		ballon1[0] = ballon1[n+1] = 1;
		//copy value to ballon1
		for(int i=1;i<=n;i++) {
			ballon1[i] = ballon[i-1];
		}
		//it records the max coins from the interval i+1 ~ j-1
		int[][] f = new int[n+2][n+2];
		
		for(int i=0;i<n+1;i++) {
			f[i][i+1] = 0;
		}
		
		for(int len=3;len<=n+2;len++) {
			for(int i=0;i<=n-len+2;i++) {
				int j = i+len-1;
				for(int k=i+1;k<j;k++) {
					f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + ballon1[i]*ballon1[j]*ballon1[k]);
				}
			}
		}
		return f[0][n+1];
	}

}
