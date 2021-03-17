package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCNo47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,1,2};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = permuteUnique(nums);
		System.out.println(res);

	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0) {
			return res;
		}
        Arrays.sort(nums);
		boolean[] isUsed = new boolean[nums.length];
		dfs(nums,nums.length,0,isUsed,list,res);
		return res;
    }
	
	public static void dfs(int[] nums, int len, int startIndex, boolean[] isUsed,
			List<Integer> list, List<List<Integer>> res) {
		if(startIndex==len) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i=0;i<len;i++) {
			if(isUsed[i] || (i>0 && nums[i]==nums[i-1]&& !isUsed[i-1])) {
				continue;
			}
            
			list.add(nums[i]);
			isUsed[i]=true;
			dfs(nums, len, startIndex+1, isUsed,list,res);
			isUsed[i]=false;
			list.remove(list.size()-1);
		}
	}

}



