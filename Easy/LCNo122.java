package leetcodeEasy;

public class LCNo122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,1,5,3,6,4};
		System.out.println(buysAndSellGreedy(arr));
		System.out.println(buyAndSellDP(arr));

	}
	
	public static int buysAndSellGreedy(int[] arr) {
		int profit = 0;
		for(int i=1;i<arr.length;i++) {
			profit += Math.max(0, arr[i]-arr[i-1]);
		}
		
		return profit;
	}
	
	public static int buyAndSellDP(int[] arr) {
		int n = arr.length;
		int[] f1 = new int[n];
		int[] f2 = new int[n];
		
		f1[0] = 0;
		f2[0] = -arr[0];
		
		for(int i=1;i<arr.length;i++) {
			f1[i] = Math.max(f1[i-1], f2[i-1]+arr[i]);
			f2[i] = Math.max(f2[i-1], f1[i-1]-arr[i]);
		}
		
		return f1[n-1];
	}

}
