import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(candidates == null || candidates.length == 0) return result;
		
		Arrays.sort(candidates);

		recurSoln(0, candidates, target, new ArrayList<Integer>(), result);

		return result;

    }

	private void recurSoln(int i, int[] candidates, int target, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result) {
		if(target < 0) return;
		
		if(target == 0) {
			result.add( new ArrayList<Integer>(tmp));
			return;
		}

		for( int j=i; j<candidates.length; j++) {
			if(j>0 && candidates[j] == candidates[j-1]) continue;

			tmp.add(candidates[j]);
			recurSoln(j, candidates, target - candidates[j], tmp, result);
			tmp.remove(tmp.size()-1);
		}
	}
}