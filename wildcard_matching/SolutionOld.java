public class SolutionOld {
    public boolean isMatch(String s, String p) {


		// base cases
		if(s.length() == 0 && p.length() == 0 ) return true;
		if(s.length() != 0 && p.length() == 0 ) return false;
		if(s.length() == 0 && p.length() != 0 ) {
			if( p.charAt(0) != '*' ) {
				return false;
			} else {
				return isMatch(s, p.substring(1, p.length()) );
			}
		}

		// other cases
		if( p.charAt(0) == '*' ) {
			// if next is also '*', skip this step
			if( p.length()>1 && p.charAt(1) == '*') {
				return isMatch(s, p.substring(1, p.length() ) );
			} else {
			
				for(int i=0; i<=s.length(); i++) {
					if( isMatch(s.substring(i, s.length()), p.substring(1, p.length() ) ) ) {
						return true;
					}
				}
				return false;
			}
		} else if( p.charAt(0) == '?') {
			return isMatch( s.substring(1, s.length() ), p.substring(1, p.length() ) );
		} else {
			if( s.charAt(0) != p.charAt(0) ) return false;
			return isMatch( s.substring(1, s.length() ), p.substring(1, p.length() ) );
		}			
    }
}