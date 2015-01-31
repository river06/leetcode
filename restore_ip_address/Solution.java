import java.util.*;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
		recur(new String(), s, 0, ret);
		return ret;
    }

	public void recur(String cur_s, String rem_s, int level, ArrayList<String> ret) {
		// base case
		if(level == 3) {
			if(isValidAddress(rem_s)) {
				cur_s+='.';
				cur_s+=rem_s;
				ret.add( new String(cur_s) );
			}
			return;
		}

		// other cases
		for(int i=1; i<=3; i++) {
			if(i<=rem_s.length()) {
				if(isValidAddress(rem_s.substring(0,i))) {
					String new_cur_s = cur_s;
					if(level >0) new_cur_s += '.';
					new_cur_s += rem_s.substring(0, i);
					recur(new_cur_s, rem_s.substring(i), level+1, ret);
				}
			}
		}
	}

	public boolean isValidAddress(String s) {
		if(s == null || s.length() == 0 || s.isEmpty()) return false;
		if(s.length() > 3) return false;
		if(s.length()>1 && s.charAt(0) == '0') return false;
		
		int num_s =  Integer.parseInt(s);
		if( 0<= num_s && num_s<=255) {
			return true;
		} else {
			return false;
		}
	}
}