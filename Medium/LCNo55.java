package leetcodeMedium;

public class LCNo55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canJump(int[] A) {
		int n=A.length;
		boolean[] f = new boolean[n];
		f[0] = true; //initialization
		
		for(int j=1;j<n;j++) {
			f[j] = false;
			//previous stone i
			//last jump is from i to j
			for(int i=0;i<j;i++) {
				if(f[i] && i+A[i]>=j) {
					f[j] = true;
					break;
				}
			}
		}
		
		return f[n-1];
	}

}
