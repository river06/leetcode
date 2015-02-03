public class Solution {
    public void solveSudoku(char[][] board) {
        backTracking(board, 0, 9);
    }

	public boolean backTracking(char[][] board, int n_fill, int l) {
		if(n_fill == l*l) {
			return true;
		}

		int x = n_fill/l;
		int y = n_fill%l;

		if(board[x][y] != '.') {
			return backTracking(board, n_fill+1, l);
		} else {
			for(char c='1'; c<='9'; c++) {
				if( isValid(board, n_fill, l, c) ) {
					board[x][y] = c;
					if( backTracking(board, n_fill+1, l) ) return true;
					board[x][y] = '.';
				}
			}
		}
		return false;
	}

	public boolean isValid(char[][] board, int n_fill, int l, char digit) {

		int x = n_fill/l;
		int y = n_fill%l;

		for(int i=0; i<l; i++) {
			if( ( board[x][i]==digit && i!=y ) ||
				( board[i][y]== digit && i!=x ) ) {
				return false;
			}
		}


		int x0 = x/3 *3;
		int y0 = y/3 *3;
		for( int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if( board[x0+i][y0+j] == digit &&
					(x0+i != x || y0+i != y) ) {
					return false;
				}
			}
		}
		return true;
	}
			
}