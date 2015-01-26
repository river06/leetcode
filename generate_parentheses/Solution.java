import java.util.*;

public class Solution {
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
		if(n==0) return result; //?

		recurGenPar(n, 0, 0, result, new String());

		return result;
    }

	private static void recurGenPar(int n, int l, int r, ArrayList<String> result, String s) {
		// base cases
		if(l<r) return;

		if(l==n && r<n) {
			recurGenPar(n, l, r+1, result, s+')');
		} else if (l==n && r==n) {
			result.add(s);
		} else {
			recurGenPar(n, l, r+1, result, s+')');
			recurGenPar(n, l+1, r, result, s+'(');
		}

	}
}