package leetcodeMedium;

public class LCNo279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PerfectSquares(12));

	}
	
	public static int PerfectSquares(int num) {
		if(num==0) {
			return 0;
		}
		int[] f = new int[num+1];
		f[0] = 0;
		for(int i=1;i<=num;i++) {
			f[i] = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				f[i] = Math.min(f[i-j*j]+1, f[i]);
			}
		}
		return f[num];
	}

}
