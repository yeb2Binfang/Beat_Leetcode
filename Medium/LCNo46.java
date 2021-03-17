package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LCNo46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] nums = new int[]{1,2,3};
		res = permute(nums);
		System.out.println(res);

	}
	
	public static List<List<Integer>> permute(int[] nums){
		
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0) {
			return res;
		}
		int len = nums.length;
		boolean[] isUsed = new boolean[len];
		int depth = 0;
		dfs(nums, len, depth, isUsed,list,res);
		return res;
		
	}

	public static void dfs(int[] nums, int len, int depth, boolean[] isUsed, List<Integer> list,
			List<List<Integer>> res) {
		
		if(depth==len) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i=0;i<len;i++) {
			if(isUsed[i]) {
				continue;
			}
			list.add(nums[i]);
			isUsed[i] = true;
			dfs(nums,len,depth+1,isUsed,list,res);
			list.remove(list.size()-1);
			isUsed[i] = false;
		}
		
		
	}
	

}
