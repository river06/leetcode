package hw;
import java.util.*;

public class Solution {
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> result = new ArrayList<Integer>();
    	result.add(1);
    	
    	if (rowIndex == 0) {
        	return result;
        } else {
        	for(int i=1; i<=rowIndex; i++){
        		int tmp = result.get(0);
        		
        		for(int j=1; j<i; j++){
        			int tmp_val = tmp + result.get(j);
        			tmp = result.get(j);
        			result.set(j, tmp_val);
        		}
        		
        		result.add(1);
        	}
        	
        	return result;
        }
    }
}
