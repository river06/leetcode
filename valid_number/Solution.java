public class Solution {

	// a tedious and not interesting question
    public boolean isNumber(String s) {
		s = s.trim(); // deal with empty spaces in head and tail

		if(s.length()==0) return false;
		
		boolean is_init_digit = true;
		boolean is_0_init = false;
		boolean is_e_present = false;
		boolean is_dot_present = false;
		boolean is_mp_present = false;


		// try to catch all invalid cases, yaha!
		// everybody if kongfu fighting!

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if( c == '+' || c=='-') {
				if(is_init_digit && !is_mp_present && !is_dot_present) {
					if(i==s.length()-1) return false;
					is_mp_present = true;
				} else {
					return false;
				}
			} else if( c=='.' ) {
				if(is_dot_present || (is_init_digit && i==s.length()-1) || is_e_present) {
					return false;
				} else {
					is_0_init = false;
					is_dot_present = true;
					is_init_digit = true;
					is_e_present = false;
				}
			} else if( c=='e') {
				if( is_e_present || i==s.length()-1 ||
					(is_init_digit && (s.charAt(0)=='.')) || i==0 ) {
					return false;
				} else {
					if( s.charAt(i-1) == '-' || s.charAt(i-1) == '+' ) return false;
					is_e_present = true;
					is_init_digit = true;
					is_0_init = false;
					is_dot_present = false;
					is_mp_present = false;
				}
			} else if( '0'<=c && c<='9' ) {
				//if( c == '0' &&  is_0_init ) return false; 
				is_init_digit = false;
			} else {
				return false;
			}
		}
		return true;
    }
}