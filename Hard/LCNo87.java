package leetcodeHard;

public class LCNo87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "great";
		String s2 = "rgeat";
		System.out.println(ScrambleString(s1, s2));
		

	}
	
	public static boolean ScrambleString(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		if(ch1.length!=ch2.length) {
			return false;
		}
		
		int n = ch1.length;
		
		//state express
		boolean[][][] f = new boolean[n][n][n+1];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				f[i][j][1] = (ch1[i]==ch2[j]);
			}
			
		}
		
		//the length starts from 2
		for(int k=2;k<=n;k++) {
			//the start index of S1
			for(int i=0;i<=n-k;i++) {
				//the start index of S2
				for(int j=0;j<=n-k;j++) {
					//the partition position
					f[i][j][k] = false;
					for(int w=1;w<=k-1;w++) {
						//case 1: no swap
						if(f[i][j][w] && f[i+w][j+w][k-w]) {
							f[i][j][k] = true;
							break;
						}
						
						//case 2: swap
						if(f[i][j+k-w][w] &&f[i+w][j][k-w]) {
							f[i][j][k] = true;
							break;
						}
					}
				}
			}
		}
		return f[0][0][n];
		
		
	}

}
