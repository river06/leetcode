public class Solution {
    public void setZeroes(int[][] matrix) {
        // use first row and first column to store zeros?
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean zero_in_first_row = false;
		for(int i=0; i<n; i++) {
			if(matrix[0][i] == 0) {
				zero_in_first_row = true;
				break;
			}
		}

		boolean zero_in_first_column = false;
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				zero_in_first_column = true;
				break;
			}
		}

		// mark all zeros
		for(int i=1; i<m; i++) {
			for( int j=1; j<n; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// set all zeros
		for(int i=1; i<m; i++) {
			for( int j=1; j<n; j++) {
				if(matrix[0][j]==0 || matrix[i][0]==0) {
					matrix[i][j] = 0;
				}
			}
		}

		// set first row or column to zero
		if(zero_in_first_row) {
			for(int i=0;i<n;i++) {
				matrix[0][i] = 0;
			}
		}
		if(zero_in_first_column) {
			for(int i=0; i<m; i++) {
				matrix[i][0] = 0;
			}
		}
    }
}