import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// this solution uses backsteping and recursion
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		boolean[] valid = new boolean[num.length];
		Arrays.fill(valid, true);
		
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
				valid[i] = false;
				per.add(num[i]);
				backStepSolver(valid, num, level+1, per, ret);
				per.remove(level);
				valid[i] = true;
			}
		}
	}
				
}