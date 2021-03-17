package leetcodeMedium;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array nums and a target value k, 
 * find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.
 */

public class lcNo325 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,5,2,7,1,9};
		int maxlen = maxSizeSubarrEqualsToK(arr, 15);
		System.out.println(maxlen);

	}
	
	public static int maxSizeSubarrEqualsToK(int[] arr, int k) {
		Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLen = 0;
		for(int i = 0; i< arr.length;i++) {
			sum += arr[i];
			
			if(sum == k) {
				maxLen = i+1;
			}
			if(!hashtable.containsKey(sum)) {
				hashtable.put(sum, i);
			}
			
			if(hashtable.containsKey(sum-k)) {
				if(maxLen < (i - hashtable.get(sum-k))) {
					maxLen = i - hashtable.get(sum-k);
				}
			}
		}
		
		return maxLen;
	}

}
