public class Solution {
    public int atoi(String str) {
        str = str.trim();
		if(str.length() == 0) return 0;

		int idx_start = 0;
		boolean neg = (str.charAt(0) == '-');
		if(str.charAt(0) == '-' || str.charAt(0) == '+') idx_start ++;

		int result = 0;
		int i = idx_start;
		while( i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9') {

			if(neg) {
				if( -(Integer.MIN_VALUE/10) < result ) return Integer.MIN_VALUE;
				if( -(Integer.MIN_VALUE/10) == result && -(Integer.MIN_VALUE %10) < str.charAt(i)-'0') {
					return Integer.MIN_VALUE;
				}
			} else {
				if( (Integer.MAX_VALUE/10) < result ) return Integer.MAX_VALUE;
				if( (Integer.MAX_VALUE/10) == result && (Integer.MAX_VALUE %10) < str.charAt(i)-'0') {
					return Integer.MAX_VALUE;
				}
			}
			result *= 10;
			result += str.charAt(i)-'0';
			i++;
		}
		if(neg) {
			return -result;
		} else {
			return result;
		}
    }
}