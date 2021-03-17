package leetcodeMedium;

public class LCNo112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root==null) {
			return false;
		}
		
		if(root.left==null && root.right==null) {
			return targetSum==root.val;
		}
		
		return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
		
    }
}
