public class Solution {
    public int numTrees(int n) {
        // base case
		if(n==0) return 1;
		if(n==1) return 1;

		int result = 0;

		for(int i=0; i<n; i++) {
			int left_nodes = i;
			int right_nodes = n-1-i;
			result += (numTrees(left_nodes) *numTrees(right_nodes));
		}
		return result;
    }
}