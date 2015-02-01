import java.util.*;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // base case
		if(s1.length() != s2.length()) {
			//System.out.println("Cheers");
			return false;
		}
		if(s1.length()==1) {
			if(s1.equals(s2)){
				return true;
			} else {
				return false;
			}
		}

		// other case
		if(s1.equals(s2)) return true;
		char[] t1 = s1.toCharArray();
		char[] t2 = s2.toCharArray();
		Arrays.sort(t1);
		Arrays.sort(t2);
		if( !Arrays.equals(t1,t2) ) return false;

		boolean result = false;
		for(int i=1;i<s1.length();i++) {
			if(isScramble( s1.substring(0,i), s2.substring(0,i) ) &&
			   isScramble( s1.substring(i,s1.length()), s2.substring(i,s2.length()))) {
				result = true;
				break;
			}
			if(isScramble( s1.substring(0,i), s2.substring(s2.length()-i,s2.length()) ) &&
			   isScramble( s1.substring(i,s1.length()), s2.substring(0,s2.length()-i))) {
				result = true;
				break;
			}
		}
		return result;
    }
}