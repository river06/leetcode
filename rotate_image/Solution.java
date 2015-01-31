public class Solution {
    public void rotate(int[][] matrix) {
		// get height/width of matrix
		int n = matrix.length;
		int sum_0 = n-1;
		int sub_0 = 0;
		for(int i=0; i<=(n-1)/2; i++) {
			for( int j=0; j<n/2; j++) {
				int x1 = i;
				int y1 = j;
				int tmp = matrix[x1][y1];
				for(int k=0; k<4; k++) {
					int x2 = sub_0 + y1;
					int y2 = sum_0 - x1;
					int tmp2 = matrix[x2][y2];
					matrix[x2][y2] = tmp;
					tmp = tmp2;
					x1 = x2;
					y1 = y2;
				}
			}
		}
    }
}