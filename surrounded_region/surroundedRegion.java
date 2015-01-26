public class Solution {
    public void solve(char[][] board) {
		int nRow = board.length;
		if(nRow == 0) return;
		
		int nCol = board[0].length;
        boolean[][] isVisited = new boolean[nRow][nCol];
		
		for(int i=0;i<nRow;i++) {
			for(int j=0; j<nCol; j++) {
				isVisited[i][j] = false;
			}
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<nRow; i++) {
			int j = 0;
			if( board[i][j] == 'O' ) {
				queue.add(nCol*i+j);
				isVisited[i][j] = true;
			}
			
			j = nCol-1;
			if( board[i][j] == 'O' ) {
				queue.add(nCol*i+j);
				isVisited[i][j] = true;
			}
		}
		
		for(int j=0; j<nCol; j++) {
			int i = 0;
			if( board[i][j] == 'O' ) {
				queue.add(nCol*i+j);
				isVisited[i][j] = true;
			}
			
			i = nRow-1;
			if( board[i][j] == 'O' ) {
				queue.add(nCol*i+j);
				isVisited[i][j] = true;
			}
		}
		
		bfs(board, isVisited, queue);
		
		for(int i=0; i<nRow; i++) {
			for(int j=0; j<nCol; j++) {
				if(!isVisited[i][j]) {
					board[i][j] = 'X';
				}
			}
		}
			
    }
	
	private void bfs(char[][] board, boolean[][] isVisited, LinkedList<Integer> queue) {
		
		int nRow = board.length;
		int nCol = board[0].length;
		
		while(!queue.isEmpty()) {
			int tmp = queue.removeFirst();
			
			int x = tmp / nCol;
			int y = tmp % nCol;
			
			isVisited[x][y] = true;
			
			if(x+1<nRow && !isVisited[x+1][y] && board[x+1][y] == 'O') {
				queue.add( (x+1)* nCol + y );
			}
			
			if(x-1>=0 && !isVisited[x-1][y] && board[x-1][y] == 'O') {
				queue.add( (x-1)* nCol + y );
			}
			
			if(y+1<nCol && !isVisited[x][y+1] && board[x][y+1] == 'O') {
				queue.add( x* nCol + y+1 );
			}
			
			if(y-1>=0 && !isVisited[x][y-1] && board[x][y-1] == 'O') {
				queue.add( x* nCol + y-1 );
			}
		}
	}		
}