package leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class LCNo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "MCMXCIV";
		System.out.println(RomanToInteger(str));
	}
	
	public static int RomanToInteger(String s) {
		Map<Character, Integer> romanHash = new HashMap<Character, Integer>();
		romanHash.put('I', 1);
		romanHash.put('V', 5);
		romanHash.put('X', 10);
		romanHash.put('L', 50);
		romanHash.put('C', 100);
		romanHash.put('D', 500);
		romanHash.put('M', 1000);
		int sum=0;
		char[] a = s.toCharArray();
		
		for(int i = 0; i<a.length;i++) {
			if(i+1<a.length && romanHash.get(a[i])<romanHash.get(a[i+1])) {
				sum = sum + romanHash.get(a[i+1]) - romanHash.get(a[i]);
				i=i+1;
			}else {
				sum += romanHash.get(a[i]);
			}
		}
		
		
		return sum;
		
	}

}
