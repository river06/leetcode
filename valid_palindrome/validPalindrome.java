public class Solution {
    public boolean isPalindrome(String s) {
		if(s.isEmpty()) return true;
		
        String lower_s = s.toLowerCase();
		
		int s_length = s.length();
		int i=0;
		int j=s_length-1;
		
		while(i<j) {
			// skip non-alphanumeric characters
			while(i<=j && !isAlphaNumeric( lower_s.charAt(i) ) ) {
				i++;
			}
			while(i<=j && !isAlphaNumeric( lower_s.charAt(j) ) ) {
				j--;
			}
			
			if(i<j && lower_s.charAt(i) == lower_s.charAt(j) ) {
				i++;
				j--;
			} else {
				break;
			}
		}
		
		if( i>=j ) {
			return true;
		} else {
			return false;
		}
    }
	
	private boolean isAlphaNumeric( char c ) {
		if( 'a' <= c && c <= 'z' ) return true;
		if( '0' <= c && c <= '9' ) return true;
		return false;
	}
}