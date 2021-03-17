package leetcodeEasy;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class LCNo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,3,3,3,4};
 		
 		System.out.println(Arrays.toString(twoSum(arr, 7)));

	}
	
	public static int[] twoSum(int[] arr, int target) {
		
		Map<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
		for (int i =0; i<arr.length;i++) {
			if(hashtable.containsKey(target - arr[i])) {
				return new int[] {hashtable.get(target-arr[i]), i};
				
			}else {
				hashtable.put(arr[i],i);
			}
		}
		
		
		return new int[0];
	}

}
