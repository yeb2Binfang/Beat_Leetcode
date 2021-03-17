package leetcodeMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LCNo229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2};
		//System.out.println(majortyElementIIHashmap(arr));
		System.out.println(majorityElementIIBoyer_Moore(arr));
		//System.out.println(majority(arr));

	}
	
	public static List<Integer> majortyElementIIHashmap(int[] arr){
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> hashmap = new HashMap<Integer,Integer>();
		for(int num : arr) {
			if(hashmap.containsKey(num)) {
				hashmap.put(num, hashmap.get(num)+1);
			}else {
				hashmap.put(num, 1);
			}
		}
		for(Entry<Integer, Integer> entry : hashmap.entrySet()) {
			if(entry.getValue()>arr.length/3) {
				list.add(entry.getKey());
			}
		}
		
		
		return list;
	}
	
	public static List<Integer> majorityElementIIBoyer_Moore(int[] arr){
		List<Integer> list = new ArrayList<Integer>();
		int count1 = 0;
		int count2 = 0;
		int major1 = arr[0];
		int major2 = arr[0];
		
		for(int num : arr) {
			if(major1==num) {
				count1++;
				continue;
			}
			if(major2==num) {
				count2++;
				continue;
			}
			
			if(count1==0) {
				major1=num;
				count1++;
				continue;
			}
			
			if(count2==0) {
				major2=num;
				count2++;
				continue;
			}
			
			count1--;
			count2--;
		
		}
		count1=count2=0;
		
		for(int num : arr) {
			if(major1==num) {
				count1++;
			}else if(major2==num) {
				count2++;
			}
		}
		
		if(count1>arr.length/3) {
			list.add(major1);
		}
		
		if(count2>arr.length/3) {
			list.add(major2);
		}
		return list;
	}
	
	
	public static List<Integer> majority(int[] nums){
		int res1 = nums[0], res2 = nums[0], count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res1) {
                count1++;
            } else if (nums[i] == res2) {
                count2++;
            } else if (count1 == 0) {
                // 当前数与2个候选人都不一样且count等于0则更换候选人
                res1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                res2 = nums[i];
                count2++;
            } else {
                // 非候选人 且 count != 0
                count1--;
                count2--;
            }
        }
        // 本题未保证一定存在2个候选人,因此还需要遍历一次确认是否大于1/3
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res1)
                count1++;
            else if (nums[i] == res2)
                count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3)
            res.add(res1);
        if (count2 > nums.length / 3)
            res.add(res2);
        return res;

	}

}
