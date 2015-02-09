public class Solution {
    public int titleToNumber(String s) {
        // how to deal with overflow?
		if(s==null || s.length()==0) return 0;
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			int digit = s.charAt(i) - 'A' + 1;
			result *= 26;
			result += digit;
		}
		return result;
    }
}