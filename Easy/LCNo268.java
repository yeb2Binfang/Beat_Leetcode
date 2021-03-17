package leetcodeEasy;

import java.util.Arrays;

public class LCNo268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0};
		//System.out.println(arr.length);
		System.out.println(MissingNumber(arr));
	}
	
	public static int MissingNumber(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(i==arr[i]) {
				continue;
			}else {
				return i;
			}
		}
		
		return n;
	}

}
