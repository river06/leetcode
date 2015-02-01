public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
		int n = matrix[0].length;

		if(m==0 || n==0) return false;

		if((matrix[0][0] > target || matrix[m-1][n-1]<target)) return false;
		// binary search get the approximate row
		int idx_row = binarySearch(target, matrix, 0, m-1);

		//System.out.println(idx_row);
		if(matrix[idx_row][0] == target) return true;

		boolean ret = binarySearch2(target, matrix[idx_row], 0, n-1);
		return ret;
		
    }

	public boolean binarySearch2(int target, int[] ary, int idx_start, int idx_end) {
		// base case
		if( idx_end - idx_start <= 1) {
			if(target == ary[idx_start] || target == ary[idx_end]){
				return true;
			} else {
				return false;
			}
		}

		int idx_mid = (idx_start + idx_end)/2;
		if(target == ary[idx_mid]) {
			return true;
		} else if (target < ary[idx_mid]) {
			return binarySearch2(target, ary, idx_start, idx_mid);
		} else {
			return binarySearch2(target, ary, idx_mid, idx_end);
		}
		
	}

	public int binarySearch(int target, int[][] matrix, int idx_start, int idx_end) {
		// base case
		if( idx_end - idx_start <= 1) {
			if(target >= matrix[idx_end][0]) {
				return idx_end;
			} else {
				return idx_start;
			}
		}

		int idx_mid = (idx_start + idx_end)/2;
		if(target == matrix[idx_mid][0]) {
			return idx_mid;
		} else if (target < matrix[idx_mid][0]) {
			return binarySearch(target, matrix, idx_start, idx_mid);
		} else {
			return binarySearch(target, matrix, idx_mid, idx_end);
		}
	}
}