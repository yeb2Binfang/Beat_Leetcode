package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class LCNo217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,1};
		System.out.println(ContainsDublicate(arr));
	}
	
	public static boolean ContainsDublicate(int[] arr) {
		
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hashmap.containsKey(arr[i])) {
				return true;
			}else {
				hashmap.put(arr[i], i);
			}
		}
		return false;
	}

}
