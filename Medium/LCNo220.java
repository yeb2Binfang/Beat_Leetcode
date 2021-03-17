package leetcodeMedium;

import java.util.HashMap;
import java.util.Map;

public class LCNo220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		//System.out.println(ContainsDublicateBruteForce(arr, 0, 3));
		System.out.println(containsNearbyAlmostDuplicate(arr,1 , 1));

	}
	
	public static boolean ContainsDublicateBruteForce(int[] arr, int t, int k) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1; (j<=i+k) && j<arr.length;j++) {
				int temp = arr[i]-arr[j];
				if(Math.abs(temp)<=t) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }


}
