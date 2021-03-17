package leetcodeEasy;

/*
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 *
 *for example: -123, it will return false
 *				121, it will return true
 *
 * 
 * */

public class LCNo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Palindrome(1234567899));
		

	}
	
	public static boolean Palindrome(int n) {
		int input = n;
		int output=0;
		int temp = 0;
		if(n==0) {
			return true;
		}
		while(n>0) {
			temp = n%10;
			if(output > Integer.MAX_VALUE/10 || (output==Integer.MAX_VALUE && temp >7)){
				return false;
			}
			if(output < Integer.MAX_VALUE/10 || (output==Integer.MAX_VALUE && temp <7)){
				output = output * 10 + temp;
				n/=10;
			}
			
		}
		if(output == input) {
			return true;
		}
		
		return false;
	}

}
