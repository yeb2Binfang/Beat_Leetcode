package leetcodeHard;

public class LCNo132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		//System.out.println(s.substring(0, 2));
		System.out.println(isPalindrome(s));
		System.out.println(PalindromePartitionII(s));

	}
	
	public static int PalindromePartitionII(String s) {
		if(s.length()==0) {
			return 0;
		}
		
		int n = s.length();
		int[] f = new int[n+1];
		f[0] = 0;
		
		for(int i=1;i<=n;i++) {
			f[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				String s1 = s.substring(j, i);
				if(isPalindrome(s1)) {
					f[i] = Math.min(f[j] + 1, f[i]);
				}
			}
		}
		
		return f[n]-1;
		
	}
	
	public static boolean isPalindrome(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length-1;
		int i = 0;
		while(i<=n) {
			if(ch[i]==ch[n]) {
				i++;
				n--;
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

}
