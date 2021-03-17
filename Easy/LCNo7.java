package leetcodeEasy;


/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within 
the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, 
assume that your function returns 0 when the reversed integer overflows.

example: input: 123
		output: 321
		
		input: 120
		output:21
		
		input:-123
		output:-321
		
		input: 0
		output: 0
		
		

 */
public class LCNo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -1200000009;
		System.out.println(reverseInt(a));
		
		

	}
	
	public static int reverseInt(int a) {
		int output = 0;
		while(a!=0) {
			int temp = a%10;
			if(output > Integer.MAX_VALUE/10 || (output == Integer.MAX_VALUE/10 && temp >7)) {
				return 0;
			}
			if(output < Integer.MIN_VALUE/10 || (output == Integer.MIN_VALUE/10 && temp <-8)) {
				return 0;
			}
			output = output * 10 + temp;
			a /= 10;
			
			
		}
		return output;
	}
	
	


}
