package leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCNo167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,4};
		//System.out.println(Arrays.toString(twoSumIIBruteForce(arr, 6)));
		//System.out.println(Arrays.toString(twoSumIIHashmap(arr, 6)));
		System.out.println(Arrays.toString(twoSumIITwoPointers(arr, 6)));

	}
	
	public static int[] twoSumIIBruteForce(int[] nums, int target) {
		int[] arr = new int[2];
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if((nums[i]+nums[j])==target){
					arr[0] = i+1;
					arr[1] = j+1;
					break;
				}
			}
		}
		
		return arr;
	}
	
	public static int[] twoSumIIHashmap(int[] nums, int target) {
		int[] arr = new int[2];
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(hashmap.containsKey((target-nums[i]))){
				arr[0] = hashmap.get(target-nums[i])+1;
				arr[1] = i+1;
				
				break;
			}else {
				hashmap.put(nums[i], i);
			}
		}
		return arr;
	}
	
	public static int[] twoSumIITwoPointers(int[] nums, int target) {
		int i=0;
		int j=nums.length-1;
		
		while(i<j) {
			int sum = nums[i] + nums[j];
			if(sum==target) {
				return new int[]{i+1,j+1};
			}else if(sum<target) {
				i++;
			}else {
				j--;
			}
		}
		return new int[]{-1, -1};
	}

}
