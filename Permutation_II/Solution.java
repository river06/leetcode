import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// this solution uses backsteping and recursion
		// this solution sorts the array first
		// other thoughts could use set instead
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		boolean[] valid = new boolean[num.length];
		Arrays.fill(valid, true);

		Arrays.sort(num);
		
        backStepSolver(valid, num, 0, new ArrayList<Integer>(), ret);

		return ret;
    }

	public void backStepSolver(boolean[] valid, int[] num, int level,
							   ArrayList<Integer> per, ArrayList<ArrayList<Integer>> ret) {
		if(level == num.length) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(per);
			ret.add(tmp);
			return;
		}

		for(int i=0; i<num.length; i++) {
			if(valid[i]) {
				if(i>0 && num[i]==num[i-1] && !valid[i-1])
					continue;
				valid[i] = false;
				per.add(num[i]);
				backStepSolver(valid, num, level+1, per, ret);
				per.remove(level);
				valid[i] = true;
			}
		}
	}
				
}