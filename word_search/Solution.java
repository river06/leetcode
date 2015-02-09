import java.util.*;
public class Solution {
    public boolean exist(char[][] board, String word) {
        // back tracking algorithm

		int m = board.length;
		if(m==0) return false;
		int n = board[0].length;
		if(n==0) return false;

		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			Arrays.fill( visited[i], false );
		}

		boolean ret = false;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if( word.charAt(0) == board[i][j]) {
					visited[i][j] = true;
					ret = backTrack(board, visited, word, 1, i, j);
					if(ret) return true;
					visited[i][j] = false;
				}
			}
		}
		return ret;
    }

	public boolean backTrack(char[][] board, boolean[][] visited,
							 String word, int idx, int x0, int y0) {
		// base case
		if( idx == word.length() ) return true;

		boolean ret = false;
		// search around
		int[] x_idx_candi = {x0, x0, x0-1, x0+1};
		int[] y_idx_candi = {y0-1, y0+1, y0, y0};
		for(int i=0; i<x_idx_candi.length; i++) {
			int x = x_idx_candi[i];
			int y = y_idx_candi[i];

			if( x<0 || x>= board.length || y<0 || y>= board[0].length) {
				continue;
			}

				// else
			if( board[x][y] == word.charAt(idx) &&
				! visited[x][y] ) {
				visited[x][y] = true;
				ret = backTrack(board, visited, word, idx+1, x, y);
				if( ret ) return ret;
				visited[x][y] = false;
			}
		}
		return ret;
	}
		

	
}