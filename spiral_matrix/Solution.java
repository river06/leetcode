import java.util.*;
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // not a very interesting question
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int m = matrix.length;
		if(m==0) return ret;
		int n = matrix[0].length;
		if(n==0) return ret;
		recurPrint(matrix, 0, 0, m, n, ret);
		return ret;
    }

	public void recurPrint(int[][] matrix, int x, int y, int m, int n, ArrayList<Integer> ret) {
		if(m==0 || n==0) return;
		if(m==1) {
			for( int i=0; i<n; i++) {
				ret.add( matrix[x][y+i] );
			}
			return;
		}
		if(n==1) {
			for(int i=0; i<m; i++) {
				ret.add( matrix[x+i][y] );
			}
			return;
		}

		// x above
		for(int i=0; i<n; i++) ret.add( matrix[x][y+i] );
		for(int i=1; i<m; i++) ret.add( matrix[x+i][y+n-1] );
		for(int i=1; i<n; i++) ret.add( matrix[x+m-1][y+n-1-i] );
		for(int i=1; i<m-1; i++) ret.add(matrix[x+m-1-i][y]);

		recurPrint(matrix, x+1, y+1, m-2, n-2, ret);
		return;
	}
			
}