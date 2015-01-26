package HW;
import java.util.*;

public class triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for( int i=0; i<3; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
			for( int j=0; j<i+1;j++) {
				tmp.add(j);
			}
			
			triangle.add(i, tmp);
		}
		
		/*
		for( int i=0; i<triangle.size(); i++) {
			for (int j=0; i<triangle.get(i).size(); j++) {
				triangle.get(i).set(j, j);
			}
			
		}*/
		
		for( int i=0; i<triangle.size(); i++) {
			for (int j=0; j<triangle.get(i).size(); j++) {
				System.out.print(triangle.get(i).get(j));
			}
			
		}
		
		
		int result = Solution.minimumTotal(triangle);
		
		System.out.println(result);
		

	}

}
