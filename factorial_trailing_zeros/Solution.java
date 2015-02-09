public class Solution {
    public int trailingZeroes(int n) {
        int five = 5;
		int n_five = 0;
		while( n >0 ) {
			int k = n/five;
			n_five += k;
			n = k;
		}
		return n_five;
    }
}