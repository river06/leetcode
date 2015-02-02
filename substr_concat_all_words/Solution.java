public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
		// this solution utilizes the sliding window algorithm
		// the complexity should be O(n/l * l) = O(n), where
		// n is the length of S, l is the length of the string in L


		// corner case
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(S == null || S.length()==0 || L==null || L.length==0) return ret;

		// build a dictionary on the string in L
		HashMap<String, Integer> dic_L = new HashMap<String, Integer>();
		for(int i=0; i<L.length; i++) {
			if(dic_L.containsKey(L[i])) {
				dic_L.put( L[i], dic_L.get( L[i] ) + 1);
			} else {
				dic_L.put( L[i], 1 );
			}
		}

		int n = S.length();
		int l = L[0].length();
//		int m = L.length;
		
		for( int i=0; i<l; i++) {
			// in order to consider all the cases, 
			HashMap<String, Integer> observed = new HashMap<String, Integer>();
			int num_L = 0;
				
			int win_s = i;

			for( int win_e = i; win_e<=n-l; win_e+=l ) {
				String cur = S.substring(win_e, win_e + l);
				if( dic_L.containsKey( cur ) ) {
					if( observed.get(cur) < dic_L.get(cur) ) {
						observed.put(cur, observed.get(cur)+1 );
						num_L ++;
					} else {
						while(win_s <= win_e) {
							String tmp = S.substring(win_s, win_s +l);
							if( tmp.equals( cur ) ) {
								win_s += l;
								break;
							} else {
								observed.put( tmp, observed.get(tmp)-1 );
								num_L --;
							}
							win_s += l;
						}
					}
				} else {
					win_s = win_e + l;
					observed.clear();
					num_L = 0;
				}
				
    }
}