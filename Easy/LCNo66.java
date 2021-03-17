package leetcodeEasy;

import java.util.Arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, 
 * increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, 
and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 
 * @author yebin
 *
 */
public class LCNo66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9, 9, 9};
		System.out.println(Arrays.toString(PlusOne(arr)));

	}
	
	public static int[] PlusOne(int[] arr) {
		for(int i=arr.length-1;i>=0;i--) {
			if((arr[i]+1)%10 !=0) {
				arr[i] = arr[i]+1;
				return arr;
			}else {
				arr[i] = 0;
			}
		}
		arr = new int[arr.length+1];
		arr[0] = 1;
		return arr;
	}

}
