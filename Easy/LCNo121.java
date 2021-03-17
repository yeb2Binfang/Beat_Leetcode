package leetcodeEasy;

public class LCNo121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prices = {7,6,4,3,1};
		//System.out.println(maxProfitBruteForce(prices));
		System.out.println(maxProfitTwoPointers(prices));
	}
	
	public static int maxProfitBruteForce(int[] prices) {
		int max = 0;
		for(int i=0;i<prices.length;i++) {
			for(int j=i+1;j<prices.length;j++) {
				max = ((prices[j]-prices[i])>max) ? (prices[j]-prices[i]) : max;
			}
		}
		
		return max;
	}
	
	public static int maxProfitTwoPointers(int[] prices) {
		int max = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++) {
			if(prices[i]<minPrice) {
				minPrice=prices[i];
			}else {
				max = (max>(prices[i]-minPrice)) ? max : (prices[i]-minPrice);
			}
		}
		return max;
	}

}
