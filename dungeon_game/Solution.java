public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
		if(m==0) return 0;
		int n = dungeon[0].length;
		if(n==0) return 0;

		// DP, but back ward!
		int[][] min_hp = new int[m][n];
		min_hp[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);

		//
		for( int j=n-2; j>=0; j--) {
			min_hp[m-1][j] = Math.max(1, min_hp[m-1][j+1] - dungeon[m-1][j]);
		}

		for( int i=m-2; i>=0; i--) {
			min_hp[i][n-1] = Math.max(1, min_hp[i+1][n-1] - dungeon[i][n-1]);
		}

		for( int i=m-2; i>=0; i--) {
			for( int j=n-2; j>=0; j--) {
				int min_hp_before_move = Math.min(min_hp[i+1][j], min_hp[i][j+1]);
				min_hp[i][j] = Math.max( 1, min_hp_before_move - dungeon[i][j]);
			}
		}
		return min_hp[0][0];
    }
}