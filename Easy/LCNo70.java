package leetcodeEasy;

public class LCNo70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCNo70 climbing = new LCNo70();
		System.out.println(climbing.climbingStairs(45));
		System.out.println(climbing.climbingStairsWithoutArr(45));

	}
	
	public int climbingStairs(int n) {
		//boundary
		//0..n: n+1
		int[] f= new int[n+1];
		f[0] =1;
		f[1] =1;
		for(int i=2;i<=n;i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
				
	}
	
	public int climbingStairsWithoutArr(int n) {
		int p=0,q=0,r=1;
		for(int i=0;i<n;i++) {
			p=q;
			q=r;
			r=p+q;
		}
		return r;
		
	}

}
