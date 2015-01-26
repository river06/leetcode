package HW;
import java.util.*;

public class Solution {
    public static List<ArrayList<Integer>> generate(int numRows) {
    	
    	if(numRows == 0) {
    		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		return result;
    	} else {
			List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			result.add(tmp);
			
	        for( int i=1; i<numRows; i++) {
				
				ArrayList<Integer> line = new ArrayList<Integer>();
				line.add(1);
				for(int j=1; j<i; j++) {
					int value = result.get(i-1).get(j-1) + result.get(i-1).get(j);
					line.add(value);
				}
				line.add(1);
				result.add(line);
			}
	        return result;
    	}
		
    }
}

