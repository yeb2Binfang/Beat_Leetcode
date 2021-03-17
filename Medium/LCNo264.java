package leetcodeMedium;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LCNo264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(nthUglyNumberBruteForce(1690));
		System.out.println(nthUglyumber(1690));

	}
	
	public static int nthUglyNumberBruteForce(int n) {
		int count = 0;
		int i=1;
		for(;i<Integer.MAX_VALUE;i++) {
			if(isUgly(i)) {
				count++;
			}
			if(count==n) {
				break;
			}
		}
		return i;
    }
	
	public static boolean isUgly(int n) {
		while(n!=1) {
			if(n%2==0) {
				n/=2;
			}else if(n%3==0) {
				n/=3;
			}else if(n%5==0) {
				n/=5;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static int nthUglyumber(int n) {
		int[] num= generateUglyNumber();
		return num[n-1];
	}
	public static int[] generateUglyNumber() {
		HashSet<Long> set = new HashSet<Long>();
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		
		set.add(1L);
		queue.offer(1L);
		int[] num = new int[1690];
		int[] prime = new int[] {2,3,5};
		
		long currUgly, newUgly;
		for(int i=0;i<1690;i++) {
			currUgly = queue.poll();
			num[i] = (int)currUgly;
			for(int j:prime) {
				newUgly = currUgly*j;
				if(!set.contains(newUgly)) {
					set.add(newUgly);
					queue.offer(newUgly);
				}
			}
		}
		return num;
		
	}

}
