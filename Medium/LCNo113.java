package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LCNo113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,3,5,2,4,2,6};
		TreeNode root = new TreeNode(-1);
		root = TreeNodeAdd.add(root, arr, 0);
		List<List<Integer>> res = pathSum(root, 8);
		System.out.println(res);
		
		

	}
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(root, targetSum,list,res);
		return res;
    }
	
	public static void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res) {
		if(root==null) {
			return;
		}
        list.add(root.val);
        targetSum-=root.val;
		if(root.left==null && root.right==null && targetSum==0) {
			res.add(new ArrayList<Integer>(list));
		}
		
		dfs(root.left, targetSum,list,res);
		dfs(root.right, targetSum,list,res);
		list.remove(list.size()-1);
		
		
	}

}
