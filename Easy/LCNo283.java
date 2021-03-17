package leetcodeEasy;

import java.util.Arrays;

public class LCNo283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,0,1,1,0};
		System.out.println(Arrays.toString(MoveZeros(arr)));

	}
	
	public static int[] MoveZeros(int[] arr) {
		int pointer1=0;
		int pointer2=0;
		
		while(pointer2<arr.length) {
			if(arr[pointer2]!=0) {
				int temp = arr[pointer1];
				arr[pointer1] = arr[pointer2];
				arr[pointer2] = temp;
				pointer1++;
			}
			pointer2++;
		}
		
		return arr;
	}

}
