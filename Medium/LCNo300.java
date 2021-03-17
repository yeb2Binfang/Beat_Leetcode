package leetcodeMedium;

import java.util.Arrays;

public class LCNo300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,9,2,5,3,7,101,18};
//		int[] arr1 = {1,2,3,4,5};
//		int n = arr1.length;
//		int i;
//		i = Arrays.binarySearch(arr1, 0, n, 1);
//		System.out.println(i);;
		System.out.println(LongestIncreasingSub(arr));
		System.out.println(LongestIncreasingSubBinarySearch(arr));
	}
	
	public static int LongestIncreasingSub(int[] arr) {
		if(arr.length==0) {
			return 0;
		}
		
		int n = arr.length;
		int[] f = new int[n];
		int res = 0;
		
		for(int i = 0;i<n;i++) {
			f[i] = 1;
			for(int j=0;j<i; j++) {
				
				
				if(arr[j] < arr[i] && f[j] + 1 > f[i]) {
					f[i] = f[j] + 1;
				}
			}
			res = Math.max(res, f[i]);
		}
		return res;
	}
	
	public static int LongestIncreasingSubBinarySearch(int[] arr) {
		if(arr.length==0) {
			return 0;
		}
		int len = 0;
		int m = arr.length;
		int[] f = new int[m];
		
		
		for(int num : arr) {
			int i = Arrays.binarySearch(f, 0, len, num);
			if(i<0) {
				i=-(i+1);
			}
			f[i] = num;
			if(i==len) {
				len++;
			}
		}
		return len;
	}

}
