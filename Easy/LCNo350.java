package leetcodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCNo350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= {4,9,5,9,5,6,7,8,3,4,6,8,1};
		int[] arr2 = {9,4,9,8,4};
		//System.out.println(Arrays.toString(InterceptionTwoArr(arr1, arr2)));
		System.out.println(Arrays.toString(InterceptionTwoArrSorted(arr1, arr2)));

	}
	
	public static int[] InterceptionTwoArr(int[] arr1, int[] arr2){
		List<Integer> list = new ArrayList<Integer>();
		if(arr2.length<arr1.length) {
			return InterceptionTwoArr(arr2, arr1);
		}
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int num : arr1) {
			if(hashmap.containsKey(num)) {
				hashmap.put(num, hashmap.get(num)+1);
			}else {
				hashmap.put(num, 1);
			}
		}
		
		for(int num : arr2) {
			if(hashmap.containsKey(num) && hashmap.get(num)>0) {
				list.add(num);
				hashmap.put(num, hashmap.get(num)-1);
			}
		}
		
		int n = list.size();
		int[] resArr = new int[n];
		for(int i=0;i<n;i++) {
			resArr[i] = list.get(i);
		}
		
		return resArr;
	}
	
	public static int[] InterceptionTwoArrSorted(int[] arr1, int[] arr2) {
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		List<Integer> list = new ArrayList<Integer>();
		
		int pointer1 = 0;
		int pointer2 = 0;
		while(pointer1 < arr1.length && pointer2<arr2.length) {
			if(arr1[pointer1] > arr2[pointer2]) {
				pointer2++;
			}else if(arr1[pointer1] < arr2[pointer2]) {
				pointer1++;
			}else {
				list.add(arr1[pointer1]);
				pointer1++;
				pointer2++;
			}
		}
		
		int n = list.size();
		int[] resArr = new int[n];
		for(int i=0;i<n;i++) {
			resArr[i] = list.get(i);
		}
		
		return resArr;
	}

}
