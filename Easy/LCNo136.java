package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;



public class LCNo136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,4,2,1,5,5,1,2};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumberExclusiveOr(nums));

	}
	
	public static int singleNumber(int[] nums) {
		
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(hashmap.containsKey(nums[i])) {
				hashmap.remove(nums[i]);
			}else {
				hashmap.put(nums[i], 1);
			}
		}
		
		for(Integer i : hashmap.keySet()) {
			return i;
		}
		return -1;
	}
	
	public static int singleNumberExclusiveOr(int[] nums) {
		int single = 0;
		for(int i : nums) {
			single ^= i;
		}
		return single;
	}

}
