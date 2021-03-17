package leetcodeEasy;

import java.util.Arrays;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) 
to hold additional elements from nums2.


 * */

public class LCNo88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10};
		System.out.println(Arrays.toString(MergeSortedArrayBruteForce(arr1, arr2)));
		

	}
	public static int[] MergeSortedArrayBruteForce(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length+arr2.length];
		int ptr1=0;
		int ptr2=0;
		boolean flag1=false, flag2=false;
		if(arr1.length==0) {
			return arr2;
		}
		if(arr2.length==0) {
			return arr1;
		}
		for(int i=0;i<arr1.length+arr2.length;i++) {
			if(ptr1 >= arr1.length) {
				flag1= true;
				break;
			}
			if(ptr2 >= arr2.length) {
				flag2= true;
				break;
			}
			if(arr1[ptr1]>=arr2[ptr2]) {
				arr[i] = arr2[ptr2];
				ptr2++;
			}else {
				arr[i] = arr1[ptr1];
				ptr1++;
			}
		}
		
		if(flag1) {
			for(int i=ptr1+ptr2;i<arr1.length+arr2.length;i++) {
				arr[i] = arr2[ptr2++];
			}
		}
		
		if(flag2) {
			for(int i=ptr1+ptr2;i<arr1.length+arr2.length;i++) {
				arr[i] = arr2[ptr1++];
			}
		}
		
		
		
		
		return arr;
	}
	



}
