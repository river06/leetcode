import java.util.*;
public class Solution {
    public int[][] generateMatrix(int n) {
        // not a very interesting question
		int[][] matrix = new int[n][n];
		if(n==0) return matrix;
		recurPrint(matrix, 0, 0, n, n, 1);
		return matrix;
    }

	public void recurPrint(int[][] matrix, int x, int y, int m, int n, int num) {
		if(m==0 || n==0) return;
		if(m==1) {
			for( int i=0; i<n; i++) {
				matrix[x][y+i] = num;
				num ++;
			}
			return;
		}
		if(n==1) {
			for(int i=0; i<m; i++) {
				matrix[x+i][y] = num;
				num++;
			}
			return;
		}

		// x above
		for(int i=0; i<n; i++) {matrix[x][y+i]=num; num++;}
		for(int i=1; i<m; i++) {matrix[x+i][y+n-1]=num; num++;}
		for(int i=1; i<n; i++) {matrix[x+m-1][y+n-1-i]=num; num++;};
		for(int i=1; i<m-1; i++) {matrix[x+m-1-i][y]=num; num++;};

		recurPrint(matrix, x+1, y+1, m-2, n-2, num);
		return;
	}
			
}