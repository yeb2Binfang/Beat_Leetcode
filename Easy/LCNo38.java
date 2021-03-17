package leetcodeEasy;

public class LCNo38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CountandSay(30));

	}
	
	public static String CountandSay(int n) {
			
		if(n==1) {
			return "1";
		}
		
		StringBuilder sb = new StringBuilder();
		String str = CountandSay(n-1) + "*";
		
		int count=1;
		for(int i =0;i<str.length()-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				count++;
			}else {
				sb.append(count);
				sb.append(str.charAt(i));
				count = 1;
			}
		}
		return sb.toString();
		
	}

}
