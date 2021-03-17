package leetcodeMedium;

/*
 * Given an array nums with n objects colored red, white, or blue, 
 * sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent 
the color red, white, and blue respectively.


 * 
 * 
 */
import java.util.Arrays;

public class LCNo75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,0,2,0,1,2,1,0};
		System.out.println(Arrays.toString(SortColors(arr)));

	}
	
	public static int[] SortColors(int[] arr) {
		
		int ptr = 0;
		int temp;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==0) {
				temp = arr[i];
				arr[i] = arr[ptr];
				arr[ptr] = temp;
				++ptr;
			}
		}
		
		for(int i = ptr; i<arr.length;i++) {
			if(arr[i]==1) {
				temp = arr[i];
				arr[i] = arr[ptr];
				arr[ptr] = temp;
				++ptr;
			}
		}
		
		
		return arr;
	}
	

}
