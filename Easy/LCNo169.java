package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.HashAttributeSet;

public class LCNo169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,1,1};
		//System.out.println(MajorityNumber(arr));
		System.out.println(MajorityNumberBayor_Moore(arr));

	}
	
	public static int MajorityNumber(int[] arr) {
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		int a =0;
		
		for(int i=0;i<arr.length;i++) {
			if(hashmap.containsKey(arr[i])) {
				hashmap.put(arr[i], hashmap.get(arr[i])+1);
			}else {
				hashmap.put(arr[i], 1);
			}
		}
		
		for(int i : hashmap.keySet()) {
			a = Math.max(a, hashmap.get(i));
		}
		
		for(Entry<Integer,Integer> entry : hashmap.entrySet()) {
			if(entry.getValue()==a) {
				return entry.getKey();
			}
		}
		
		return 0;
	}
	
	public static int MajorityNumberBayor_Moore(int[] arr) {
		
		int count = 0;
		int major = arr[0];
		for(int num : arr) {
			if(num==major) {
				count++;
			}else {
				if(count==0) {
					major=num;
				}else {
					count--;
				}
			}
		}
		return major;
	}

}
