package leetcodeMedium;

public class LCNo91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "226";
		System.out.println(DecodeWays(s));
		
		//System.out.println(s.toCharArray().length);
		
		//System.out.println();
	}
	
	public static int DecodeWays(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		if(n==0) {
			return 0;
		}
		int[] f = new int[n+1];
		f[0] = 1;
		
		for(int i=1;i<=n;i++) {
			int t = ch[i-1] - '0';
			if(t>=1 && t<=9) {
				f[i] += f[i-1];
			}
			
			if(i>=2) {
				t=(ch[i-2]-'0')*10 + (ch[i-1]-'0');
				if(t>=10 && t<=26) {
					f[i] += f[i-2];
				}
			}
			
		}
		return f[n];
	}
	
	
	
	
}
