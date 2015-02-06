import java.util.*;
public class Solution {
    public boolean isMatch(String s, String p) {
        // this method uses DP to reduce the time complexity
		// this method alse uses a single array to reduce space complexity
		
		// the double pointer approach utilizes the fact that
		// it only needs to backtrack to the latest wildcard,
		// which is quite hard to fully understand

		if( s==null && p==null ) return true;
		if( p.length() == 0 ) return s.length()==0;
		// s length could equals to zero, but can be a match

		int s_len = s.length();

		// prunning...
		int cont = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) != '*') cont ++;
		}
        if (cont > s_len) return false; 
		
		boolean[] s_matched = new boolean[s_len + 1];
		// s matched by p for i=0,...,s_len elements

		// initialize s_matched for (j=0) first p elements
		Arrays.fill(s_matched, false);
		s_matched[0] = true;

		for(int j=0; j<p.length(); j++) {
			boolean[] s_matched_new = new boolean[s_len + 1];
			if( p.charAt(j) != '*' ) {
				// if regular variable
				s_matched_new[0] = false;
				// since p is regular variable, there is no way to match s with zero element
				for( int i=0; i<s_len; i++ ) {
					s_matched_new[i+1] = s_matched[i] &&
						(p.charAt(j)== s.charAt(i) || p.charAt(j) == '?');
				}
				s_matched = s_matched_new;
			} else {
				int k = s_len+1;
				Arrays.fill(s_matched_new, false);
				for( int i=0; i<s_len+1; i++) {
					if( s_matched[i] ) {
						k = i;
						break;
					}
				}
				for( int i=k; i<s_len+1; i++) {
					s_matched_new[i] = true;
				}
				s_matched = s_matched_new;
			}
		}
		return s_matched[s_len];
			
    }
}