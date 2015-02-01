public class Solution {
    public int search(int[] A, int target) {
        if(A==null || A.length==0) return -1;
		if(A.length == 1) {
			if(A[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		// other cases
		int n = A.length;
		int new_start = findStartIndex(A, 0, n-1);
		int result = binarySearch(target, A, new_start, 0, n-1);
		return result;
			
    }
	public int binarySearch(int target, int[] A, int new_start, int idx_start, int idx_end) {
		int idx_correct_start = convertIndex(A.length, new_start, idx_start);
		int idx_correct_end = convertIndex(A.length, new_start, idx_end);

		if(idx_end - idx_start == 1) {
			if(A[idx_correct_start] == target) return idx_correct_start;
			if(A[idx_correct_end] == target) return idx_correct_end;
			return -1;
		}

		int idx_mid = (idx_start + idx_end)/2;
		int idx_correct_mid = convertIndex(A.length, new_start, idx_mid);
		if( A[idx_correct_mid] == target) return idx_correct_mid;
		if( target < A[idx_correct_mid] ) {
			return binarySearch(target, A, new_start, idx_start, idx_mid);
		} else {
			return binarySearch(target, A, new_start, idx_mid, idx_end);
		}
	}

	public int findStartIndex(int[] A, int idx_start, int idx_end) {
		// base cases
		if(A[idx_start] < A[idx_end]) return idx_start;
		if(idx_end - idx_start == 1) return idx_end;

		// other cases
		int idx_mid = (idx_start + idx_end)/2;
		if( A[idx_start] < A[idx_mid] ) {
			return findStartIndex(A, idx_mid, idx_end);
		} else {
			return findStartIndex(A, idx_start, idx_mid);
		}
	}

	public int convertIndex(int length, int idx_start, int idx) {
		return (idx_start+idx)%length;
	}
}