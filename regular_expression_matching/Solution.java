public class Solution {
    public boolean isMatch(String s, String p) {
        // this solution is hard
		// notice that '*' can match zero of preceeding element, which is wierd
		// notice that s.substring( s.length() )
		// will return an empty string rather than throwing an exception
		
		// base case
		if(p.length() == 0) return (s.length() == 0);

		// when p.length()==1, special case? also base case?
		if( p.length() == 1) {
			if(s.length() != 1) {
				return false;
			} else if (s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.') {
				return false;
			} else {
				return true;
			}
		}

		// other cases when p.length()>=2

		if(p.charAt(1) != '*') {
			if(s.length() < 1) return false;
			
			if(p.charAt(0) != s.charAt(0) && p.charAt(0) != '.'){
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else {
			// the case when the second char is '*'
			boolean tmp = isMatch(s.substring(0), p.substring(2));
			if(tmp) return true;

			for(int i=0; i<s.length(); i++) {
				if( s.charAt(i) == p.charAt(0) || p.charAt(0) == '.'  ) {
					if( isMatch(s.substring(i+1), p.substring(2) ) ){
						return true;
					}
				} else {
					break;
				}
				
			}
			return false;
		}
	}
}