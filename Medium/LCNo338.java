package leetcodeMedium;

import java.util.Arrays;

public class LCNo338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 5;
//		String s1 = Integer.toBinaryString(a);
//		System.out.println(s1);
		int num = 5;
		System.out.println(Arrays.toString(countingBitsBruceForce(num)));
		System.out.println(Arrays.toString(countingBitsDP(num)));

	}
	
	public static int[] countingBitsBruceForce(int num) {
		int[] count = new int[num+1];
		for(int i=0;i<=num;i++) {
			String s1 = Integer.toBinaryString(i);
			int temp = 0;
			for(int j=0;j<s1.length();j++) {
				if(s1.charAt(j)=='1') {
					temp++;
				}
			}
			count[i] = temp;
		}
		return count;
	}

	public static int[] countingBitsDP(int num) {
		int[] count = new int[num+1];
		count[0] = 0;
		for(int i=1;i<=num;i++) {
			count[i] = count[i>>1]+i%2;
		}
		return count;
	}
}
