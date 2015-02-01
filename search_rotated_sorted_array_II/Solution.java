public class Solution {
    public boolean search(int[] A, int target) {
		// this solution uses the left and right pointer
		// the idea is different from Search in Rotated Sorted Array
		if(A==null || A.length == 0) return false;
		
		int l = 0;
		int r = A.length-1;

		while( l<= r) {
			// notice that l could be equal to r
			int m = (l+r)/2;

			if(A[m] == target) return true;

			if(A[l] < A[m]) {
				if(A[l]<= target && target <= A[m]) {
					// search left
					r = m-1;
				} else {
					l = m+1;
				}
			} else if (A[l] > A[m]) {
				if( A[m]< target && target<=A[r]) {
					l = m+1;
				} else {
					r = m-1;
				}
			} else {
				l ++;
			}
		}
		return false;
    }
}