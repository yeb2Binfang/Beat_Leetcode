package leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class LCNo219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,1,2,3};
		//System.out.println(ContainDublicatesBruteForce(arr, 1));

		System.out.println(ContainDublicateHashset(arr, 2));
	}
	
	public static boolean ContainDublicatesBruteForce(int[] arr, int k) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;(j<=i+k) && j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean ContainDublicateHashset(int[] arr, int k) {
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(set.contains(arr[i])) {
				return true;
			}else {
				set.add(arr[i]);
			}
			
			if(set.size()>k) {
				set.remove(arr[i-k]);
			}
		}
		
		return false;
	}

}
