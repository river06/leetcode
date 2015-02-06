import java.util.*;
public class Solution {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// this version judges whether s can be representd by words in dict
		// if not, return false

		// this version does not use prunning, which is left behind later
		ArrayList<String> ret = new ArrayList<String>();
		
		boolean[] is_valid = new boolean[s.length()+1];

		is_valid[0] = true;
		for(int i=0; i<s.length(); i++) {
			if( dict.contains( s.substring(0, i+1) ) ) {
				is_valid[i+1] = true;
				continue;
			}
			for( int k=0; k<i+1; k++) {
				if( is_valid[k] && dict.contains( s.substring(k,i+1)) ) {
					is_valid[i+1] = true;
					break;
				}
			}
		}

		System.out.println( is_valid[s.length()] );

		if ( is_valid[s.length()] == false) return ret;

	   
		
		recurBreakOld(s, new String(), ret, dict);
		return ret;

    }





	public ArrayList<String> wordBreakOld(String s, Set<String> dict) {
		ArrayList<String> ret = new ArrayList<String>();
        recurBreakOld(s, new String(), ret, dict);
		return ret;
    }

	public void recurBreakOld(String s, String line, ArrayList<String>ret, Set<String> dict) {
		if(s.length()==0) {
			ret.add( new String(line) );
			return;
		}

		for(int i=1; i<=s.length(); i++) {
			if( dict.contains( s.substring(0,i) ) ) {
				String new_line = new String();
				if(line.length() ==0) {
					new_line = s.substring(0,i);
				} else {
					new_line = line + " " + s.substring(0,i);
				}
				
				recurBreakOld( s.substring(i,s.length()), new_line, ret, dict);
			}
		}
	}
			
}