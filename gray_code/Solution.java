import java.util.*;

public class Solution {
    public static ArrayList<Integer> grayCode(int n) {
        
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n<0) return result;
		result.add(0);
		if(n==0) return result;
		for(int i=1;i<=n;i++) {
			int length = result.size();
			for(int j=length-1; j>=0; j--) {
				int add_bit = (1 << (i-1));
				result.add(add_bit + result.get(j));
			}
		}
		return result;
    }
}