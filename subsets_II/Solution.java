import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        int n = S.length;
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		boolean[] used = new boolean[n];
		Arrays.fill(used, false);
		
		backTracking(S, ret, new ArrayList<Integer>(), n, 0, used);
		return ret;
    }

	public void backTracking(int[] S, ArrayList<ArrayList<Integer>> ret,
							 ArrayList<Integer> cur, int n, int level, boolean[] used) {
		if(level == n) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}

		if ( level>=1 ) {
			

				
				backTracking(S, ret, cur, n, level+1, used);

				
				if( !(S[level]==S[level-1] && !used[level-1])) {
					cur.add(S[level]);
used[level] = true;
				backTracking(S, ret, cur, n, level+1, used);
				cur.remove( cur.size()-1 );
				used[level] = false;
			}
		} else {
			
				backTracking(S, ret, cur, n, level+1, used);

				cur.add(S[level]);
used[level] = true;
				backTracking(S, ret, cur, n, level+1, used);
				cur.remove( cur.size()-1 );
				used[level] = false;
		}
	}
}