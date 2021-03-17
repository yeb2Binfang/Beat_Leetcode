package leetcodeMedium;

import java.util.HashSet;
import java.util.Set;

public class LCNo137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,99,1,1};
		//System.out.println(SingleNumberII(arr));
		
		//System.out.println(5>>1);
		System.out.println(SingleNumberIIBitMethod(arr));

	}
	
	public static int SingleNumberII(int[] arr) {
		
		Set<Integer> hashset = new HashSet<Integer>();
		int sumSet = 0;
		int sumArr = 0;
		for(int nums : arr) {
			sumArr += nums;
			hashset.add(nums);
		}
		for(int nums : hashset) {
			sumSet += nums;
		}
		
		int nums = (3*sumSet - sumArr)/2;
		
		return nums;
	}
	
	public static int SingleNumberIIBitMethod(int[] arr) {
		int res=0;
		for(int i=0;i<32;i++) {
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				//System.out.println((arr[j]>>i)&1);
				sum+=(arr[j]>>i)&1;
				System.out.println(sum);
			}
			res ^= (sum%3)<<i;
		}
		return res;
	}

}
