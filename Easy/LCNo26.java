package leetcodeEasy;

public class LCNo26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,2,3};
		System.out.println(removeDuplicates(nums));

	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;


    }
}
