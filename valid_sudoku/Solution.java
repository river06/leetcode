public class Solution {
    public boolean isValidSudoku(char[][] board) {
	   
		for(int i=0; i<9; i++) {
			if( !isValidRow(board, i) ) return false;
			if( !isValidCol(board, i) ) return false;
			if( !isValidBlock(board, i) ) return false;
		}
		return true;
    }

	public boolean isValidBlock( char[][] board, int idx) {
		int x0 = idx/3 *3;
		int y0 = (idx%3) * 3;
		int[] count = new int[9];
		Arrays.fill(count, 0);
		for(int i=0; i<3; i++) {
			for( int j=0; j<3; j++) {
				if( board[x0+i][y0+j] != '.' ) {
					if( '1'>board[x0+i][y0+j] || board[x0+i][y0+j]>'9') return false;
					count[ board[x0+i][y0+j] - '0' -1 ] ++;
					if( count[ board[x0+i][y0+j] - '0'-1 ] >1 ) return false;
				}
			}
		}
		return true;
	}
			

	public boolean isValidRow( char[][] board, int idx_row) {
		int[] count = new int[9];
		Arrays.fill(count, 0);
		for(int j=0; j<9; j++) {
			if( board[idx_row][j] != '.' ) {
				if( '1'>board[idx_row][j] || board[idx_row][j]>'9') return false;

				count[ board[idx_row][j] - '0' -1 ] ++;
				if( count[ board[idx_row][j] - '0'-1 ] >1 ) return false;
			}
		}
		return true;
	}

	public boolean isValidCol( char[][] board, int idx) {
		int[] count = new int[9];
		Arrays.fill(count, 0);
		for(int i=0; i<9; i++) {
			if( board[i][idx] != '.' ) {
				if( '1'>board[i][idx] || board[i][idx]>'9') return false;

				count[ board[i][idx] - '0' -1 ] ++;
				if( count[ board[i][idx] - '0'-1 ] >1 ) return false;
			}
		}
		return true;
	}
}