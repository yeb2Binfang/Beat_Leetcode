package leetcodeEasy;



public class LCNo1047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String removeDuplicates(String S) {
		StringBuffer sb = new StringBuffer();
		int top=-1;
		for(int i=0;i<S.length();i++) {
			if(top>=0 && S.charAt(i)==sb.charAt(top)) {
				sb.deleteCharAt(top);
				top--;
			}else {
				sb.append(S.charAt(i));
				top++;
			}
		}
		return sb.toString();
    }

}
