package leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

public class listCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		
		
	}
	
	public static boolean isInter(List<ArrayList<Integer>> circle) {
		int size = circle.size();
		for(int i=0;i<size-1;i++) {
			for(int j=1;j<size;j++) {
				double dis = Math.pow(circle.get(i).get(1), circle.get(j).get(1)) + Math.pow(circle.get(i).get(0), circle.get(j).get(0));
				double sqrtDis = Math.sqrt(dis);
				double sumR = circle.get(i).get(2) + circle.get(j).get(2);
				if(sqrtDis<sumR) {
					return true;
				}
			}
		}
		return false;
	}

}
