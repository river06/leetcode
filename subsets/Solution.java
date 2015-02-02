import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int n = S.length;
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	   
		backTracking(S, ret, new ArrayList<Integer>(), n, 0);
		return ret;
    }

	public void backTracking(int[] S, ArrayList<ArrayList<Integer>> ret,
							 ArrayList<Integer> cur, int n, int level) {
		if(level == n) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}
//		System.out.println(cur);
		backTracking(S, ret, cur, n, level+1);
		cur.add(S[level]);
//		System.out.println(cur);
		backTracking(S, ret, cur, n, level+1);
		cur.remove( cur.size()-1 );
	}
}