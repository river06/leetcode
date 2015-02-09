import java.util.*;

public class Solution {
    public String largestNumber(int[] num) {
        List<String> num_array = new ArrayList<String>();
		for( int i=0; i<num.length; i++) {
			num_array.add( Integer.toString(num[i]) );
		}
		Collections.sort( num_array, new StrCom() );

		StringBuilder sb = new StringBuilder();
		boolean isStart = true;
		for( int i=num_array.size()-1; i>=0; i--) {
			if( num_array.get(i).equals("0") && isStart) {
				continue;
			} else {
				isStart = false;
				sb.append( num_array.get(i) );
			}
		}
		if(sb.length()==0) return "0";
		return sb.toString();
			
    }
}

class StrCom implements Comparator<String> {
	public int compare(String s1, String s2) {
		String s12 = s1+s2;
		String s21 = s2+s1;
		return (int) (Long.parseLong(s12) - Long.parseLong(s21) );
	}
}